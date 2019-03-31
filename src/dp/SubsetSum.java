package dp;

import java.util.Arrays;

/*
 Variation of -
    https://www.geeksforgeeks.org/subset-sum-problem-dp-25/

 */

public class SubsetSum {
    public static void main(String[] args) {
//        System.out.println(subsetRecursive(new int[]{2, 4, 6, 10}, 16, 0));
//        System.out.println(subsetRecursive(new int[]{2, 4, 6, 10, 3, 7}, 20, 0));

//        System.out.println(subsetMemoizedHelper(new int[]{2, 2, 4, 6, 10}, 6, 0));
//        System.out.println(subsetMemoizedHelper(new int[]{1, 2, 7, 1, 5}, 10, 0));
//        System.out.println(subsetMemoizedHelper(new int[]{1, 3, 4, 8}, 6, 0));
//        System.out.println(subsetMemoizedHelper(new int[]{2, 4, 6, 10, 3, 7}, 20, 0));
        System.out.println(subsetMemoizedHelper(new int[]{2, 4, 6, 10, 3, 7}, 19, 0));

//        System.out.println(subsetBottomUp(new int[]{2, 2, 4, 6, 10}, 6));
//        System.out.println(subsetBottomUp(new int[]{1, 2, 7, 1, 5}, 10));
//        System.out.println(subsetBottomUp(new int[]{1, 3, 4, 8}, 6));
//        System.out.println(subsetBottomUp(new int[]{2, 4, 6, 10, 3, 7}, 20));
        System.out.println(subsetBottomUp(new int[]{2, 4, 6, 10, 3, 7}, 19));
    }

    private static int subsetRecursive(int[] arr, int total, int index) {
        if (total == 0) {
            return 1;
        }
        if (index == arr.length || total < 0) {
            return 0;
        }
        int count = subsetRecursive(arr, total, index + 1);
        if (arr[index] > total) {
            return count;
        } else {
            return subsetRecursive(arr, total - arr[index], index + 1) + count;
        }
    }

    private static int subsetBottomUp(int[] arr, int total) {
        Integer[][] dp = new Integer[arr.length][total + 1];

        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 0;
        }

        for (int localsum = 1; localsum <= total; localsum++) {
            dp[0][localsum] = arr[0] == localsum ? 1 : 0;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int localsum = 1; localsum < total + 1; localsum++) {
                if (localsum == arr[i]) {
                    dp[i][localsum] = 1;
                } else {
                    dp[i][localsum] = 0;
                }

                if (dp[i - 1][localsum] != 0) {
                    dp[i][localsum] += dp[i - 1][localsum];
                }
                if (localsum >= arr[i]) {
                    dp[i][localsum] += dp[i - 1][localsum - arr[i]];
                }
            }
        }

        print(arr, total, dp);

        return dp[arr.length - 1][total];
    }

    private static void print(int[] arr, int total, Integer[][] dp) {
        System.out.println(Arrays.toString(arr));
        System.out.print("     sum: ");

        for (int j = 0; j < total + 1; j++) {
            System.out.print("  " + j);
        }
        System.out.println("\n-------------------------------------------");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Subset " + i + " -> ");
            for (int j = 0; j < total + 1; j++) {
                System.out.print((dp[i][j] == null ? 0 : dp[i][j]) + "  ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------");
    }

    private static int subsetMemoizedHelper(int[] arr, int total, int index) {
        Integer[][] dp = new Integer[arr.length][total + 1];
        int c = subsetMemoized(dp, arr, total, index);
/*
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < total + 1; j++) {
                System.out.print((dp[i][j] == null ? 0 : dp[i][j]) + " ");
            }
            System.out.println();
        }
*/
        print(arr, total, dp);
        return c;
    }

    private static int subsetMemoized(Integer[][] dp, int[] arr, int total, int index) {
        if (total == 0) {
            return 1;
        }
        if (index == arr.length || total < 0) {
            return 0;
        }
        if (dp[index][total] != null) {
            return dp[index][total];
        }
        int count = subsetMemoized(dp, arr, total, index + 1);
        if (arr[index] > total) {
            dp[index][total] = count;
            return count;
        } else {
            int count1 = subsetMemoized(dp, arr, total - arr[index], index + 1) + count;
            dp[index][total] = count1;
            return count1;
        }
    }
}
