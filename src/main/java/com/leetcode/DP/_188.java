package com.leetcode.DP;

public class _188 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2 || prices == null) return 0;
        if (k == 0) return 0;
        //定义dp[i][j][k]  j=0表示不持有股票j=1表示持有股票
        //dp表示第i天最多完成k笔交易持有或者不持有最大利润
        int dp[][][] = new int[prices.length + 1][2][k + 1];
//        dp[1][1][0] = -prices[0];
//        dp[1][0][0] = 0;
        for (int i = 0; i <= k; i++) {
            dp[0][0][i] = 0;
            dp[0][1][i] = -prices[0];
        }
        //dp[2][0][1] = Math.max(prices[1] - prices[0], 0);
        for (int i = 1; i < prices.length; i++) {
            dp[i][0][0] = 0; // 等于0更合适
            dp[i][1][0] = Math.max(dp[i-1][0][0]-prices[i],dp[i-1][1][0]);

            for (int j = 1; j <= k; j++) {
//                if (i > j + 1) {
                    dp[i][0][j] = max(dp[i][0][j - 1], dp[i - 1][1][j - 1] + prices[i], dp[i - 1][0][j]);
                    dp[i][1][j] = max(dp[i - 1][1][j], dp[i - 1][0][j] - prices[i], dp[i][1][j - 1]);
//                    dp[i][0][j] = Math.max(dp[i - 1][1][j - 1] + prices[i ], dp[i - 1][0][j]);
//                    dp[i][1][j] = Math.max(dp[i - 1][1][j], dp[i][0][j] - prices[i - 1]);
//                }
            }
        }
        return dp[prices.length-1][0][k];
    }

    private int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    public static void main(String[] args) {
       int num[] = {6,4,1, 23, 4};
//       int num[] = {3, 2, 6, 5, 0, 3};
        //int num[] = {2,1,4,5,2,9,7};
        new _188().maxProfit(2, num);
    }
}
