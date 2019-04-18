package heap;

import java.util.PriorityQueue;
import java.util.TreeSet;

// https://www.careercup.com/question?id=5686055997014016
public class NthMultiple {
    public static void main(String[] args) {
        System.out.println(getNthMultiple(new int[]{4, 6}, 6));
        System.out.println(getNthMultiple(new int[]{3, 5}, 10));
        System.out.println(getNthMultiple(new int[]{2, 20}, 6));
    }

    private static int getNthMultiple(int[] nums, int n) {
        TreeSet<Integer> set = new TreeSet<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            for (int num : nums) {
                int product = num * i;
                if (!set.contains(product)) {
                    queue.add(product);
                    set.add(product);
                }
            }
        }
        while (!queue.isEmpty() && --n > 0)
            queue.remove();

        System.out.println(set);
        return queue.peek();
    }
}