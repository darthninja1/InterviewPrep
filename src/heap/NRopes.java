package heap;

import com.google.common.primitives.Ints;

import java.util.PriorityQueue;

// https://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/
public class NRopes {
    public static void main(String[] args) {
        System.out.println(getMinCost(new int[]{4, 3, 2, 6}) == 29);
        System.out.println(getMinCost(new int[]{4, 2, 9, 8, 15}) == 81);
        System.out.println(getMinCost(new int[]{ 3, 7, 9, 4}) == 44);
        System.out.println(getMinCost(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}) == 135);
    }

    private static int getMinCost(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        } else if (arr.length == 1) {
            return arr[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Ints.asList(arr));
        int sum = 0;
        while (!queue.isEmpty()) {
            int first = queue.poll();
            if (queue.isEmpty()) {
                break;
            }
            int second = queue.poll();
            sum += first + second;
//            System.out.println("Sum: " + sum);
            queue.offer(first + second);
//            System.out.println("Adding: " + first + " + " + second);
        }
        return sum;
    }
}