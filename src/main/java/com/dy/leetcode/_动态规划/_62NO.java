package com.dy.leetcode._动态规划;

public class _62NO {
    public int uniquePaths(int m, int n) {
        //定义 dp[m][n] 是从 [0,0][m-1,n-1]的路径总和
        Integer dp[][] = new Integer[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        //dp[1][1] = 2;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (dp[i][j] == null) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else if (j < m && i < n) {
                    dp[j][i] = dp[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        new _62NO().uniquePaths(7,3);
    }
}
