package com.dy.leetcode._动态规划;

import java.util.*;

public class _322 {
    //    List<List<Integer>> res = new ArrayList<>();
    List<Integer> pathList = new ArrayList<>();
    int min = Integer.MAX_VALUE;
    int i = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        coinChange(coins, amount, coins.length - 1);
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }

    //思路1：递归取最大的一个，只要大于amount就取上一层的前一个
    private void coinChange(int[] coins, int amount, int index) {
        i++;
//        if (map.containsKey(amount)) {
//            return;
//        }//371977
        if (pathList.size() > min) {
            return;
        }
        if (amount < coins[0]) {
            return;
        }
        if (index < 0) {
            return;
        }
        //剪枝
        if (pathList.size() + amount / coins[index] >= min) {
            return;
        }
        if (coins[index] > amount) {
            index--;
        }
        for (int i = index; i >= 0; i--) {
            pathList.add(coins[i]);
            if (amount == coins[i]) {
                if (pathList.size() < min) {
                    min = pathList.size();
                    map.put(amount, min);
                }
            } else {
                coinChange(coins, amount - coins[i], i);
            }
            pathList.remove(pathList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {470, 35, 120, 81, 121};
        new _322().coinChange(nums, 9825);
//        int[] nums = {1, 2, 5};
//        new _322().coinChange(nums, 19);
//
//        int[] nums = {3, 7, 405, 436};
//        new _322().coinChange(nums, 8839);
    }
}
