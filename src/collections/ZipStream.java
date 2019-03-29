package collections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

// http://blog.agiledeveloper.com/2014/10/working-around-lack-of-zip-function-in.html
public class ZipStream {
    public static void main(String[] args) {
        final List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4);
        final List<Integer> numbers2 = Arrays.asList(10, 20, 30);
        IntStream.range(0, Math.min(numbers1.size(), numbers2.size()))
                .mapToObj(i -> numbers1.get(i) + numbers2.get(i))
                .forEach(System.out::println);

        final List<String> str1 = Arrays.asList("A", "B", "C");
        final List<String> str2 = Arrays.asList("1", "2", "3");
        IntStream.range(0, Math.min(str1.size(), str2.size()))
                .mapToObj(i -> str1.get(i) + str2.get(i))
                .forEach(System.out::println);
    }
}
