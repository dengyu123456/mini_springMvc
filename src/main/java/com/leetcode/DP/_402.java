package com.leetcode.DP;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by D on 2021/4/16.
 */
public class _402 {
    public String removeKdigits(String num, int k) {
        int a = num.length() - k;
        if (a <= 0) return "0";
//        Map<String, Integer> map = new HashMap<>();
        //dp（i，j）表示前i个字符移除掉j个字符表示的最大值
        AA dp[][] = new AA[num.length()][k + 1];
        //先找出AA dp[a+1][1]的值

        new AA(0, 0);
        return dp[num.length() - 1][k] + "";

    }

    public static void main(String[] args) {
        String a = "1261";
        a.replace('1', ' ');
    }
}

class AA {
    int dp;

    //存储dp（i，j）当中最大的一个值在num当中的索引；
    int maxIndex;

    public AA(int dp, int maxIndex) {
        this.dp = dp;
        this.maxIndex = maxIndex;
    }
}
