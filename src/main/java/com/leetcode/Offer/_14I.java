package com.leetcode.Offer;

public class _14I {
    public int cuttingRope(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = max(dp[i - j] * j, dp[i], (i - j) * j);
                dp[i]=dp[i]%1000000007;
            }
        }
        return dp[n];
    }

    private int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    public static void main(String[] args) {
        System.out.println(new _14I().cuttingRope(5));
    }
}
