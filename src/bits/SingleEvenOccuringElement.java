package bits;

import com.google.common.collect.Lists;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// http://www.ardendertat.com/2011/11/29/programming-interview-questions-18-find-even-occurring-element/
public class SingleEvenOccuringElement {
    public static void main(String[] args) {
        System.out.println(findEven(Lists.newArrayList(1, 2, 1, 3, 4, 3, 3, 1, 1)));
    }

    private static int findEven(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        int xor = 0;
        for (Integer num : list) {
            xor ^= num;
        }
        for (Integer num : set) {
            xor ^= num;
        }
        return xor;
    }
}
