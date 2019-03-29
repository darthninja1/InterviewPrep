package collections;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

// https://stackoverflow.com/questions/53307682/how-to-interleave-merge-two-java-8-streams
public class InterleaveStreams {
    public static void main(String[] args) {
        final List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        final List<Integer> numbers2 = Arrays.asList(10, 20, 30);

        Stream<Integer> s = interleave(numbers1.stream(), numbers2.stream());
        s.forEach(System.out::println);

        Stream<String> a = Stream.of("one", "three", "five", "seven");
        Stream<String> b = Stream.of("two", "four", "six");

        // Alternative solution - requires same sized streams
        Stream<String> out = interleave2(a, b);
        out.forEach(System.out::println);
    }

    public static <T> Stream<T> interleave(Stream<T> a, Stream<T> b) {
        Spliterator<T> spA = a.spliterator(), spB = b.spliterator();
        long s = spA.estimateSize() + spB.estimateSize();
        if (s < 0) s = Long.MAX_VALUE;
        int ch = spA.characteristics() & spB.characteristics()
                & (Spliterator.NONNULL | Spliterator.SIZED);
        ch |= Spliterator.ORDERED;

        return StreamSupport.stream(new Spliterators.AbstractSpliterator<T>(s, ch) {
            Spliterator<T> sp1 = spA, sp2 = spB;

            @Override
            public boolean tryAdvance(Consumer<? super T> action) {
                Spliterator<T> sp = sp1;
                if (sp.tryAdvance(action)) {
                    sp1 = sp2;
                    sp2 = sp;
                    return true;
                }
                return sp2.tryAdvance(action);
            }
        }, false);
    }

    public static <T> Stream<T> interleave2(Stream<T> streamA, Stream<T> streamB) {
        return zip(streamA, streamB, (o1, o2) -> Stream.of(o1, o2)).flatMap(s -> s);
    }

    /**
     * https://stackoverflow.com/questions/17640754/zipping-streams-using-jdk8-with-lambda-java-util-stream-streams-zip
     **/
    private static <A, B, C> Stream<C> zip(Stream<A> streamA, Stream<B> streamB, BiFunction<A, B, C> zipper) {
        final Iterator<A> iteratorA = streamA.iterator();
        final Iterator<B> iteratorB = streamB.iterator();
        final Iterator<C> iteratorC = new Iterator<C>() {
            @Override
            public boolean hasNext() {
                return iteratorA.hasNext() && iteratorB.hasNext();
            }

            @Override
            public C next() {
                return zipper.apply(iteratorA.next(), iteratorB.next());
            }
        };
        final boolean parallel = streamA.isParallel() || streamB.isParallel();
        return iteratorToFiniteStream(iteratorC, parallel);
    }

    private static <T> Stream<T> iteratorToFiniteStream(Iterator<T> iterator, boolean parallel) {
        final Iterable<T> iterable = () -> iterator;
        return StreamSupport.stream(iterable.spliterator(), parallel);
    }
}
