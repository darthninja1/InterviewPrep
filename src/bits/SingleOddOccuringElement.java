package bits;

import com.google.common.collect.Lists;

import java.util.List;

// http://www.ardendertat.com/2011/12/13/programming-interview-questions-22-find-odd-occurring-element/
public class SingleOddOccuringElement {
    public static void main(String[] args) {
        System.out.println(findOdd(Lists.newArrayList(1, 2, 1, 3, 2, 3, 4, 4, 4, 3, 3, 1, 1)));
    }

    private static int findOdd(List<Integer> list) {
        int xor = 0;
        for (Integer num : list) {
            xor ^= num;
        }
        return xor;
    }
}
