package com.dy.leetcode._动态规划;

public class _63NO {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //定义 dp[m][n] 是从 [0,0][m-1,n-1]的路径总和
        int dp[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] != 1) {
                dp[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] != 1) {
                dp[0][i] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[i].length; j++) {
                //dp[i][j]=dp[i-1][j]+dp[i][j-1]
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] nums = {
                {0, 1, 0},
                {0, 1, 0},
                {0, 0, 0}};
        new _63NO().uniquePathsWithObstacles(nums);
    }
}
