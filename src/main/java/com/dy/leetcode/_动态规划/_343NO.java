package com.dy.leetcode._动态规划;

public class _343NO {
    Integer max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public int integerBreak(int n) {
        Integer dp[] = new Integer[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        //定义：dp[i]是分解后的最大乘积
        for (int i = 2; i < dp.length; i++) {
            //将i分解成 j，i-j 两个部分
            for (int j = 1; j < i; j++) {
                if (dp[i] == null) {
                    dp[i] = Math.max(j * (i - j), j * dp[i - j]);
                } else {
                    dp[i]=max3(dp[i],j * (i - j), j * dp[i - j]);
                }

            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new _343NO().integerBreak(10));
    }
}
