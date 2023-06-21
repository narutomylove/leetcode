package com.sany.dp;

public class _0188 {

    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length + 1][k + 1][2];
        for (int i = 0; i < k + 1; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = Integer.MIN_VALUE;
        }
        for (int i = 1; i < prices.length + 1; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE;
        }
        for (int m = 1; m <= prices.length; m++) {
            for (int n = 1; n <= k; n++) {
                dp[m][n][0] = Math.max(dp[m -1][n][1], dp[m -1][n - 1][0] - prices[m - 1]);
                dp[m][n][1] = Math.max(dp[m -1][n][0], dp[m -1][n][1] + prices[m - 1]);
            }
        }
        return dp[prices.length][k][0];
    }

    public int maxProfit1(int k, int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        for (int i = 1; i <= prices.length; i++) {
            dp[i][1] = Math.max(dp[i -1][1], dp[i -1][0] - prices[i - 1]);
            dp[i][0] = Math.max(dp[i -1][0], dp[i -1][1] + prices[i - 1]);
        }
        return dp[prices.length][0];
    }

    public int maxProfit2(int[] prices) {
        if (prices.length < 3) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[1][0] = Math.max(0, prices[1] - prices[0]);
        dp[0][1] = -prices[0];
        dp[1][1] = Math.max(dp[0][1], -prices[1]);

        for (int i = 2; i < prices.length; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    public static int maxProfit3(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int length = prices.length;
        int[][][] dp = new int[length][2][3];

        dp[0][0][1] = Integer.MIN_VALUE;
        dp[0][0][2] = Integer.MIN_VALUE;
        dp[0][1][0] = -prices[0];
        dp[0][1][1] = Integer.MIN_VALUE;
        //dp[0][1][2] = Integer.MIN_VALUE;

        for (int i =  1; i < length; i++) {
            dp[i][0][1] = Math.max(dp[i - 1][1][0] + prices[i], dp[i - 1][0][1]);
            dp[i][0][2] = Math.max(dp[i - 1][1][1] + prices[i], dp[i - 1][0][2]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], -prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][1] - prices[i]);
        }

        return Math.max(0, Math.max(dp[length - 1][0][1], dp[length - 1][0][2]));
    }

    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        maxProfit3(prices);
    }
}
