package com.leetcode.Offer;

public class _10II {
    //    public int numWays(int n) {
//        if (n == 1||n == 0) return 1;
//        int dp[] = new int[n + 1];
//        dp[1] = 1;
//        dp[2] = 2;
//        for (int i = 3; i <= n; i++) {
//            dp[i] = (dp[i - 1] + dp[i - 2]);
//            dp[i] = dp[i] % 1000000007;
//        }
//        return dp[n];
//    }
    public int numWays(int n) {
        if (n == 1 || n == 0) return 1;
//        int dp[] = new int[n + 1];
        int pre1 = 2;
        int pre2 = 1;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = pre1;
            pre1 = pre2 + pre1;
            pre1=pre1%1000000007;
            pre2 = temp;
        }
        return pre1;
    }

    public static void main(String[] args) {
        System.out.println(new _10II().numWays(4));
    }
}
