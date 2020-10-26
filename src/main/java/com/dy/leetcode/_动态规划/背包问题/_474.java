package com.dy.leetcode._动态规划.背包问题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _474 {

    int[][] _01Nums = null;


    public int findMaxForm(String[] strs, int m, int n) {
        _01Nums = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            for (char cha : chars) {
                if (cha == '1') {
                    _01Nums[i][1]++;
                } else {
                    _01Nums[i][0]++;
                }
            }
        }
        //定义：dp[m][n]是放入背包最多的值  dp[m][n]=max(1+dp[m-_01Nums[i][0]][n-_01Nums[i][1]],dp[m][n])
        int dp[][] = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 0; i < _01Nums.length; i++) {
            for (int k = m; k >= _01Nums[i][0]; k--) {
                for (int v = n; v >= _01Nums[i][1]; v--) {
                    dp[k][v] = Math.max(1 + dp[k - _01Nums[i][0]][v - _01Nums[i][1]], dp[k][v]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String[] strings = {"10", "0001", "111001", "1", "0"};

        new _474().findMaxForm(strings, 5, 3);
    }
}
