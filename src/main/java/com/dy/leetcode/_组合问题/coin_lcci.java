package com.dy.leetcode._组合问题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//面试题 08.11. 硬币
//硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
//
//示例1:
//
// 输入: n = 5
// 输出：2
// 解释: 有两种方式可以凑成总金额:
//5=5
//5=1+1+1+1+1
//示例2:
//
// 输入: n = 10
// 输出：4
// 解释: 有四种方式可以凑成总金额:
//10=10
//10=5+5
//10=5+1+1+1+1+1
//10=1+1+1+1+1+1+1+1+1+1
public class coin_lcci {


    public Map<Integer, Integer> targetMap = new HashMap<>();

    int count = 0;
    public static int a[] = {1, 5, 10, 25};
    public static int c = 1000000007;

    public int waysToChange(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = a[i]; j <= n; j++) {
                dp[j] = (dp[j] + dp[j - a[i]]) % c;
            }
        }

        return dp[n];
    }

//    public void combinationSum(int[] candidates, int target, int minIndex) {
//        if (targetMap.containsKey(target)) {
//            count=count+targetMap.get(target);
//            return;
//        }
//        for (int i = minIndex; i < candidates.length; i++) {
//            //如果大于target，则退出
//            if (candidates[i] > target) {
//                return;
//            }
//            if (candidates[i] == target&&!targetMap.containsKey(target)) {
//                count++;
//            }
//            if (candidates[i] < target) {
//                combinationSum(candidates, target - candidates[i], i);
//            }
//        }
//    }

    public static void main(String[] args) {
        coin_lcci coin_lcci = new coin_lcci();
        System.out.println(coin_lcci.waysToChange(10));
    }
}
