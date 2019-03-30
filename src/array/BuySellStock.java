package array;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BuySellStock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 5, 4, 3, 2, 1}));
        System.out.println(maxProfit(new int[]{1, 1, 1, 2, 3, 1, 5, 3, 1, 8}));
    }

    private static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(prices[i] - min, profit);
            min = Math.min(min, prices[i]);
        }
        return profit;
    }
}
