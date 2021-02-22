package com.leetcode.DP;

public class _822 {
    //
    int min = Integer.MAX_VALUE;
    public int superEggDrop(int K, int N) {
        return dp(K, N);
    }

    public int dp(int k, int n) {
        if (k == 1) return n;
        if (n == 0) return 0;

        for (int i = 1; i <= n; i++) {
            min = Math.min(min, Math.max(dp(k , n - i), dp(k-1, n-1))+1);
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new _822().superEggDrop(2, 6));
    }

}
