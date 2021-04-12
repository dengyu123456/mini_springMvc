package com.leetcode.DP;

public class _122 {
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length + 1][2];
        dp[1][0] = 0;
        dp[1][1] = -prices[0];
        for (int i = 2; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], (dp[i - 1][1] + prices[i - 1]));
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i - 1]);
        }
        return dp[prices.length][0];
    }
}
