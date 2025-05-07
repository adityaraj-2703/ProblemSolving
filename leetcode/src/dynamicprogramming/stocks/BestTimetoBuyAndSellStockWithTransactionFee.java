package dynamicprogramming.stocks;

public class BestTimetoBuyAndSellStockWithTransactionFee {

    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        int prev1 = prices[0];
        int prev2 = prices[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][1];
            prev1 = Math.min(prev1, prices[i]);
            if (prices[i] - prev2 > fee) {
                dp[i][1] = dp[i][0] + prices[i] - prev2 - fee;
                prev1 = Integer.MAX_VALUE;
            }

        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
        // return maxProfitUtil(prices,fee,0,Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        BestTimetoBuyAndSellStockWithTransactionFee b = new BestTimetoBuyAndSellStockWithTransactionFee();
        int[] prices = { 1, 3, 2, 8, 4, 9 };
        int fee = 2;
        System.out.println(b.maxProfit(prices, fee));
    }
}
