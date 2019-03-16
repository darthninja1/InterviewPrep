package dp;

public class Knapsack {
    public static void main(String[] args) {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int capacity = 7;
        Integer[][] dp = new Integer[weights.length][capacity + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        System.out.println(maximizeTopDown(profits, weights, dp, capacity, 0));
        System.out.println(maximizeBottomUp(profits, weights, capacity, 0));
//        print(dp);

        int val[] = {22, 20, 15, 30, 24, 54, 21, 32, 18, 25};
        int wt[] = {4, 2, 3, 5, 5, 6, 9, 7, 8, 10};
        capacity = 30;
        System.out.println(maximizeRecursive(val, wt, 30, 0));
/*
        Integer[][] dp2 = new Integer[wt.length][capacity + 1];
        System.out.println(maximizeTopDown(val, wt, dp2, capacity, 0));
        print(dp2);
*/
    }

    static int maximizeRecursive(int[] profits, int[] weights, int capacity, int index) {
        if (capacity <= 0 || index >= weights.length) {
            return 0;
        }
        int profit1 = 0;
        if (weights[index] <= capacity) {
            profit1 = profits[index] + maximizeRecursive(profits, weights, capacity - weights[index], index + 1);
        }
        int profit2 = maximizeRecursive(profits, weights, capacity, index + 1);
        return Math.max(profit1, profit2);
    }

    static int maximizeTopDown(int[] profits, int[] weights, Integer[][] dp, int capacity, int index) {
        if (capacity <= 0 || index >= weights.length) {
            return 0;
        }
        if (dp[index][capacity] == null) {
            int profit1 = 0;
            if (weights[index] <= capacity) {
                profit1 = profits[index] + maximizeTopDown(profits, weights, dp, capacity - weights[index], index + 1);
            }
            int profit2 = maximizeTopDown(profits, weights, dp, capacity, index + 1);
            dp[index][capacity] = Math.max(profit1, profit2);
        }
        return dp[index][capacity];
    }

    static int maximizeBottomUp(int[] profits, int[] weights, int capacity, int index) {
        int[][] dp = new int[weights.length][capacity + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int c = 0; c < capacity + 1; c++) {
            if (weights[0] <= c) {
                dp[0][c] = profits[0];
            }
        }

        for (int i = 1; i < weights.length; i++) {
            for (int c = 1; c < capacity + 1; c++) {
                int profit1 = 0, profit2 = 0;
                if (weights[i] <= c) {
                    profit1 = profits[i] + dp[i - 1][c - weights[i]];
                }
                profit2 = dp[i - 1][c];
                dp[i][c] = Math.max(profit1, profit2);
            }
        }
        return dp[weights.length - 1][capacity];
    }

    private static void print(Integer[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print((dp[i][j] == null ? 0 : dp[i][j]) + " ");
            }
            System.out.println();
        }
    }
}
