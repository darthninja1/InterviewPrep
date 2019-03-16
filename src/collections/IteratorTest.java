package collections;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorTest {
    public static void main(String[] args) {
        List<String> foo = Lists.newArrayList("a", "b", "c", "d");
        List<String> boo = Lists.newArrayList("a1", "b1", "c1", "d1");
        Iterator<String> itr = foo.iterator();
        ListIterator<String> litr = foo.listIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();
        while (litr.hasNext()) {
            String tmp = litr.next();
            litr.set(tmp + "2");
        }
        Iterator<String> newItr = Iterators.concat(foo.iterator(), boo.iterator());
        while (newItr.hasNext()) {
            System.out.print(newItr.next() + " ");
        }
        System.out.println();
    }
}
