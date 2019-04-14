package array;

import java.util.Arrays;

// https://www.programcreek.com/2014/07/leetcode-range-addition-java/
// http://buttercola.blogspot.com/2018/07/leetcode-370-range-addition.html
public class RangeAddition {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getModifiedArray(5, new int[][]{{1, 3, 2}, {2, 4, 3}, {0, 2, -2}})));
    }

    private static int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length];
        for (int i = 0; i < updates.length; i++) {
            int start = updates[i][0];
            int end = updates[i][1];
            int value = updates[i][2];
            arr[start] += value;
            // Mark the next entry as negative value
            if (end < length - 1) {
                arr[end + 1] -= value;
            }
        }
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
        }
        return arr;
    }

    // O(n^2)
    private static int[] getModifiedArray2(int length, int[][] updates) {
        int[] arr = new int[length];
        for (int i = 0; i < updates.length; i++) {
            int start = updates[i][0];
            int end = updates[i][1];
            int value = updates[i][2];
            for (int j = start; j <= end; j++) {
                arr[j] += value;
            }
        }
        return arr;
    }
}