package com.leetcode.DP;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class _416 {
    boolean res = false;

    //第一种解法
    public boolean canPartition(int[] nums) {
        Long sum = 0l;
        for (int i : nums) {
            sum = i + sum;
        }
        if (sum % 2 != 0) return false;
        long target = sum / 2;
        //如果在数组中找到可以满足tager的子数组，true
        dp(nums, target, 0);
        return res;
    }

    private void dp(int[] nums, long target, int index) {
        if (target == 0) {
            res = true;
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (target - nums[i] < 0) continue;
            if (res) return;
            dp(nums, target - nums[i], i + 1);
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int nums[] = {100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97};
        new _416().canPartition(nums);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

}

