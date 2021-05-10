package com.leetcode.DP;

import java.math.BigDecimal;

public class _518 {
    public int change(int amount, int[] coins) {
        //dp[i][j]表示[0..i)种硬币可以凑成价值为j的凑法数量
        int dp[][] = new int[coins.length + 1][amount + 1];
//        for (int j = 0; j < coins.length; j++) {
//            dp[j][0] = 1;
//        }
        for (int i = 0; i <= coins.length; i++)
            dp[i][0] = 1;
//        for (int i = 1; i < coins.length; i++) {
//            for (int j = 1; j <= amount; j++) {
//                if (j - coins[i - 1] >= 0) {
//                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
//                } else {
//                    dp[i][j] = dp[i - 1][j];
//                }
//            }
//        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++)
                if (j - coins[i-1] >= 0)
                    dp[i][j] = dp[i - 1][j]
                            + dp[i][j - coins[i-1]];
                else
                    dp[i][j] = dp[i - 1][j];
        }
        return dp[coins.length][amount];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        System.out.println(new _518().change(5, nums));
//        System.out.println(new BigDecimal(220000000-77000000));
    }
}
