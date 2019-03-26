package array;

// https://leetcode.com/problems/maximum-subarray/
public class MaximumSubarraySum {
    public static void main(String[] args) {
        System.out.println(maxSubarraySum(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubarraySum(new int[]{-2, -1, -3, -4, -1, -2, -1, -5, -4}));
        System.out.println(maxSubarraySum(new int[]{-2, 1, -3, -4, -1}));
    }

    private static int maxSubarraySum(int[] num) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < num.length; i++) {
            currentSum = Math.max(currentSum + num[i], num[i]);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
}
