package array;

import java.util.Arrays;

// https://www.geeksforgeeks.org/two-elements-whose-sum-is-closest-to-zero/
// https://www.geeksforgeeks.org/given-an-array-a-and-a-number-x-check-for-pair-in-a-with-sum-as-x/
public class PairClosestToSum {
    public static void main(String[] args) {
        findPair(new int[]{2, 3, 4, -3, 8, 0, 7}, 0);
        findPair(new int[]{2, 3, 4, -3, 8, 0, 7}, 1);
        findPair(new int[]{2, 3, 4, -3, 8, 0, 7}, 20);
        findPair(new int[]{2, 3, 4, -3, 8, 0, 7}, -5);
        findPair(new int[]{2, 3, 4, -3, 8, 0, 7}, -2);
    }

    private static void findPair(int[] arr, int closestSum) {
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length - 1;
        int minSum = Integer.MAX_VALUE;
        int minStart = -1;
        int minEnd = arr.length;
        while (end > start) {
            int sum = arr[start] + arr[end];
            if (sum == closestSum) {
                System.out.println("Exact sum found: " + arr[start] + " and " + arr[end]);
                return;
            }
            if (Math.abs(sum) < Math.abs(closestSum)) {
                minSum = sum;
                minEnd = end;
                minStart = start;
            }
            if (sum > closestSum) {
                end--;
            } else {
                start++;
            }
        }
        System.out.println("Closest sum " + minSum + " found : " + arr[minStart] + " and " + arr[minEnd]);

    }
}
