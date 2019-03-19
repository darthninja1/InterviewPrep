package array;

import com.google.common.collect.Lists;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        List<Integer> input = Lists.newArrayList(100, 4, 200, 1, 3, 2);
        System.out.println(countLCS(input));
        System.out.println(countLCS(Lists.newArrayList(1, 9, 0, 3, 10, 4, 20, 2)));
    }

    private static int countLCS(List<Integer> input) {
        int count = 0;
        Set<Integer> numbers = new HashSet<>(input);
        for (int num : numbers) {
            if (numbers.contains(num - 1)) continue;

            int c = 1;
            while (numbers.contains(num + c)) {
                c++;
            }
            if (c > count) {
                count = c;
            }
        }
        return count;
    }
}
