package dp;

import java.util.Arrays;

public class EqualPartition {
    public static void main(String[] args) {
        System.out.println(partitionRecursive(new int[]{1, 2, 3, 4}));
        System.out.println(partitionRecursive(new int[]{1, 4, 2, 3}));
        System.out.println(partitionRecursive(new int[]{1, 2, 3, 5}));
        System.out.println(partitionRecursive(new int[]{1, 5, 11, 5}));
        System.out.println();
        System.out.println(partitionMemoized(new int[]{1, 2, 3, 4}));
        System.out.println(partitionMemoized(new int[]{1, 4, 2, 3}));
        System.out.println(partitionMemoized(new int[]{1, 2, 3, 5}));
        System.out.println(partitionMemoized(new int[]{1, 5, 11, 5}));
        System.out.println();
        System.out.println(partitionBottomUp(new int[]{1, 2, 3, 4}));
        System.out.println(partitionBottomUp(new int[]{1, 4, 2, 3}));
        System.out.println(partitionBottomUp(new int[]{1, 2, 3, 5}));
        System.out.println(partitionBottomUp(new int[]{1, 5, 11, 5}));
    }

    private static boolean partitionRecursive(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        if (sum % 2 != 0) return false;
        int halfSum = sum / 2;
        return partitionRecursiveHelper(arr, halfSum, 0);
    }

    private static boolean partitionRecursiveHelper(int[] arr, int sum, int index) {
        if (sum == 0) {
            return true;
        }
        if (arr.length == 0 || index >= arr.length) {
            return false;
        }
        if (arr[index] <= sum) {
            if (partitionRecursiveHelper(arr, sum - arr[index], index + 1)) {
                return true;
            }
        }
        return partitionRecursiveHelper(arr, sum, index + 1);
    }

    private static boolean partitionMemoized(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        if (sum % 2 != 0) return false;
        int halfSum = sum / 2;
        Boolean[][] dp = new Boolean[arr.length][halfSum + 1];
        return partitionMemoizedHelper(arr, halfSum, 0, dp);
    }

    private static boolean partitionMemoizedHelper(int[] arr, int sum, int index, Boolean[][] dp) {
        if (sum == 0) {
            return true;
        }
        if (arr.length == 0 || index >= arr.length) {
            return false;
        }
        if (dp[index][sum] == null) {
            if (arr[index] <= sum) {
                if (partitionRecursiveHelper(arr, sum - arr[index], index + 1)) {
                    dp[index][sum] = true;
                    return true;
                }
            }
            dp[index][sum] = partitionRecursiveHelper(arr, sum, index + 1);
        }
        return dp[index][sum];
    }

    /*
                 0  1  2  3  4  5
         {1}     T  T  F  F  F  F
        {1,2}    T  T  F
       {1,2,3}   T  T
      {1,2,3,4}  T  T
    */
    private static boolean partitionBottomUp(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        if (sum % 2 != 0) return false;
        int halfSum = sum / 2;
        boolean[][] dp = new boolean[arr.length][halfSum + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        for (int s = 0; s < halfSum + 1; s++) {
            if (arr[0] == s) {
                dp[0][s] = true;
            }
        }
        for (int i = 1; i < arr.length; i++) {
            for (int s = 1; s < halfSum + 1; s++) {
                if (dp[i - 1][s]) {
                    dp[i][s] = true;
                } else if (s >= arr[i])
                    dp[i][s] = dp[i - 1][s - arr[i]];
            }
        }
        print(dp);
        return dp[arr.length - 1][halfSum];
    }

    private static void print(boolean[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print((dp[i][j] ? "T" : "F") + " ");
            }
            System.out.println();
        }
    }
}

