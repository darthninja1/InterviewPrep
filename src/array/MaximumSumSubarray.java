package array;

// https://leetcode.com/problems/maximum-subarray/
public class MaximumSumSubarray {
    public static void main(String[] args) {
        System.out.println(maxSum(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSum(new int[]{-2, -1, -3, -4, -1, -2, -1, -5, -4}));
        System.out.println(maxSum(new int[]{-2, 1, -3, -4, -1}));
    }

    private static int maxSum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currentSum = Math.max(currentSum + arr[i], arr[i]);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
}
