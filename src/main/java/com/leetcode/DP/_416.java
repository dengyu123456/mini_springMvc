package com.leetcode.DP;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

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
        //如果在前i（包含i）个数中找到可以满足tager的子数组，true
        boolean dp[][] = new boolean[nums.length][sum + 1];

        return dp[nums.length - 1][sum];
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int nums[] = {100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 99, 97};
        new _416().canPartition(nums);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

}

