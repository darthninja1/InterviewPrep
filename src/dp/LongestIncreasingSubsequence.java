package dp;

import java.util.Arrays;

import static dp.LongestCommonSubsequence.lcsBottomUp;

// https://leetcode.com/problems/longest-increasing-subsequence/
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        lisUsingLCS();
        int[] arr = {4, 2, 3, 6, 10, 1, 12, 22};
        System.out.println(lisRecursive(arr, 0, -1));
        System.out.println(lisBottomUp(arr));
        arr = new int[]{-4, 10, 3, 7, 15};
        System.out.println(lisRecursive(arr, 0, -1));
        System.out.println(lisBottomUp(arr));
    }

    private static void lisUsingLCS() {
        String s = "asbzcurdg";
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        System.out.println(s);
        System.out.println(String.valueOf(arr));
        System.out.println(lcsBottomUp(s, String.valueOf(arr)));
    }

    private static int lisRecursive(int[] arr, int current, int previous) {
        if (current == arr.length) return 0;
        int c1 = 0;
        if (previous == -1 || arr[current] > arr[previous]) {
            // include current
            c1 = 1 + lisRecursive(arr, current + 1, current);
        }
        // exclude current
        int c2 = lisRecursive(arr, current + 1, previous);
        return Math.max(c1, c2);
    }

    private static int lisBottomUp(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] <= dp[j]) {
                    dp[i] = 1 + dp[j];
                    maxLength = Math.max(maxLength, dp[i]);
                }
            }
        }
        return maxLength;
    }
}