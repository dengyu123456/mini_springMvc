package com.leetcode.DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//动态规划其实就是对穷举做一个优化
//先写出暴力解，递归函数的定义和状态，以及状态转移的过程
//再采用备忘录  再转换为dp就简单了
public class _322 {
//    //第一种解法：穷举递归
//    public int coinChange(int[] coins, int amount) {
//        return dp(coins, amount);
//    }
//
//    //状态：唯一改变的状态就是amount，由于硬币无限，所以不存在选择的硬币也是状态
//    //函数返回定义：返回该amount下所需的最小币种
//
//    //base case：
//    //1、当amount等于0时则找到了刚好凑够amount的硬币 直接返回0
//    //2、当amount小于0时返回-1，无解
//
//    //状态转移：选择了当前硬币则则amount减少对应的金额
//    public int dp(int[] coins, int amount) {
//        if (amount == 0) return 0;
//        if (amount < 0) return -1;
//        int min = Integer.MAX_VALUE;
//        //穷举所有情况
//        for (int coin : coins) {
//            int dp = dp(coins, amount - coin);
//            if (dp == -1) continue;
//            min = Math.min(1 + dp, min);
//        }
//        if (min==Integer.MAX_VALUE)return -1;
//        System.out.println(min);
//        return min;
//    }


//
//    //优化加备忘录
//    Map<Integer,Integer> map=new HashMap<>();
//    public int coinChange(int[] coins, int amount) {
//        Arrays.sort(coins);
//        return dp(coins, amount);
//    }
//    //状态：唯一改变的状态就是amount，由于硬币无限，所以不存在选择的硬币也是状态
//    //函数返回定义：返回该amount下所需的最小币种
//
//    //base case：
//    //1、当amount等于0时则找到了刚好凑够amount的硬币 直接返回0
//    //2、当amount小于0时返回-1，无解
//
//    //状态转移：选择了当前硬币则amount减少对应的金额
//    public int dp(int[] coins, int amount) {
//        if (map.get(amount)!=null)return map.get(amount);
//        if (amount == 0) return 0;
//        if (amount < 0) return -1;
//        int min = Integer.MAX_VALUE;
//        //穷举所有情况
//        for (int i=coins.length-1;i>0;i--) {
//            int dp = dp(coins, amount - coins[i]);
//            if (dp == -1) continue;
//            min = Math.min(1 + dp, min);
//        }
//        if (min==Integer.MAX_VALUE)return -1;
//       if (!map.containsKey(amount)){
//           map.put(amount,min);
//       }
//        return min;
//    }

//    //优化加备忘录
//    Map<Integer,Integer> map=new HashMap<>();
//    public int coinChange(int[] coins, int amount) {
//        return dp(coins, amount);
//    }

    //状态：唯一改变的状态就是amount，由于硬币无限，所以不存在选择的硬币也是状态
    //函数返回定义：返回该amount下所需的最小币种

    //base case：
    //1、当amount等于0时则找到了刚好凑够amount的硬币 直接返回0
    //2、当amount小于0时返回-1，无解

    //状态转移：选择了当前硬币则amount减少对应的金额
//    public int dp(int[] coins, int amount) {
//        if (map.get(amount)!=null)return map.get(amount);
//        if (amount == 0) return 0;
//        if (amount < 0) return -1;
//        int min = Integer.MAX_VALUE;
//        //穷举所有情况
//        for (int coin : coins) {
//            int dp = dp(coins, amount - coin);
//            if (dp == -1) continue;
//            min = Math.min(1 + dp, min);
//        }
//        if (min==Integer.MAX_VALUE)return -1;
//        if (!map.containsKey(amount)){
//            map.put(amount,min);
//        }
//        return min;
//    }

    //动态规划 去除子问题
    //转移方程：dp[amount]=min(dp[amount],1+dp[amount-coin])
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        //初始化
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE/2;
        }
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount] == Integer.MAX_VALUE/2 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        //[186,419,83,408]
        //6249
        int coins[] = {186, 419, 83, 408};
        System.out.println(new _322().coinChange(coins, 6249));
    }
}
