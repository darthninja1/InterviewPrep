package sort;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://www.techiedelight.com/sort-k-sorted-array/
public class KSortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortKSortedArray(new int[]{2, 1, 3, 5, 4, 7, 6, 8}, 2)));
    }

    private static int[] sortKSortedArray(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k + 1);
        int[] result = new int[arr.length];
        int idx = 0;
        for (int i = 0; i < arr.length; ) {
            int j = i;
            for (; j <=  i + k && j < arr.length; j++) {
                queue.offer(arr[j]);
            }
            i = j;
            while (!queue.isEmpty()) {
                result[idx++] = queue.poll();
            }
        }
        return result;
    }
}