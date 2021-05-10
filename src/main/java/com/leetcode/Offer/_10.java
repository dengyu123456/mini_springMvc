package com.leetcode.Offer;

public class _10 {
    public int fib(int n) {
        if (n == 0) return 0;
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]);
            dp[i] = dp[i] % 1000000007;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new _10().fib(3));
    }
}
