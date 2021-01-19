package com.dy.leetcode._动态规划;

import jdk.internal.org.objectweb.asm.tree.IincInsnNode;
import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.*;

public class _322 {
    //    List<List<Integer>> res = new ArrayList<>();
//    List<Integer> pathList = new ArrayList<>();
//    int min = Integer.MAX_VALUE;
//    int i = 0;
//
////思路1：递归取最大的一个，只要大于amount就取上一层的前一个
//    public int coinChange(int[] coins, int amount) {
//        if (amount == 0) {
//            return 0;
//        }
//        Arrays.sort(coins);
//        coinChange(coins, amount, coins.length - 1);
//        if (min == Integer.MAX_VALUE) {
//            return -1;
//        }
//        return min;
//    }
//
//    private void coinChange(int[] coins, int amount, int index) {
//        i++;
////        if (map.containsKey(amount)) {
////            return;
////        }//371977
//        if (pathList.size() > min) {
//            return;
//        }
//        if (amount < coins[0]) {
//            return;
//        }
//        if (index < 0) {
//            return;
//        }
//        //剪枝
//        if (pathList.size() + amount / coins[index] >= min) {
//            return;
//        }
//        if (coins[index] > amount) {
//            index--;
//        }
//        for (int i = index; i >= 0; i--) {
//            pathList.add(coins[i]);
//            if (amount == coins[i]) {
//                if (pathList.size() < min) {
//                    min = pathList.size();
//                }
//            } else {
//                coinChange(coins, amount - coins[i], i);
//            }
//            pathList.remove(pathList.size() - 1);
//        }
//    }
    //思路2：动态规划
    public int coinChange(int[] coins, int amount) {
        //dp[amount]为满足等于amount的最币种  dp[i]=min(dp[i-coins[i]])
        int dp[] = new int[amount + 1];
        dp[0] = 0;
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        if (coins == null || coins[0] > amount) {
            return -1;
        }
        for (int j = 0; j <= amount; j++) {
            dp[j] = Integer.MAX_VALUE / 2;
        }
        for (int i = coins.length - 1; i >= 0; i--) {
            if (coins[i] <= amount)
                dp[coins[i]] = 1;
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i] > 0)
                    dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
            }
        }
        if (dp[amount] == Integer.MAX_VALUE / 2) {
            return -1;
        }
        return dp[amount];
    }
    public static void main(String[] args) {
//        int[] nums = {2};
//        System.out.println(new _322().coinChange(nums, 1));
        int[] nums = {1, 2, 5};
        new _322().coinChange(nums, 11);
//
//        int[] nums = {3, 7, 405, 436};
//        new _322().coinChange(nums, 8839);
    }
}
