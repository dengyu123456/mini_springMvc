package com.leetcode.DP;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.util.concurrent.ForkJoinPool;

public class _416 {
    boolean res = false;
//
//    //第一种解法
//    public boolean canPartition(int[] nums) {
//        Long sum = 0l;
//        for (int i : nums) {
//            sum = i + sum;
//        }
//        if (sum % 2 != 0) return false;
//        long target = sum / 2;
//        //如果在数组中找到可以满足tager的子数组，true
//        dp(nums, target, 0);
//        return res;
//    }
//
//    private void dp(int[] nums, long target, int index) {
//        if (target == 0) {
//            res = true;
//            return;
//        }
//        for (int i = index; i < nums.length; i++) {
//            if (target - nums[i] < 0) continue;
//            if (res) return;
//            dp(nums, target - nums[i], i + 1);
//        }
//    }

    //第一种解法
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum = i + sum;
        }
        if (sum % 2 != 0) return false;
        sum = sum / 2;
        boolean dp[][] = new boolean[nums.length + 1][sum + 1];
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }
        //如果在前i（包含i）个数中找到可以满足tager的子数组，true

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                //装不下第i个物品
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //背包有容量：
                    //取决于第i-1个物品的重量 j-num[i]是不是被装满 那么放入第i个物品 num【i】 则刚好装满
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][sum];
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        //int nums[] = {100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 99, 97};
        int nums[] = {1, 1, 1, 1, 2};
        new _416().canPartition(nums);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

}

