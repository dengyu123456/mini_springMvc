package com.leetcode.DP;

/**
 * Created by D on 2021/3/31.
 */
public class _152 {
    public int maxProduct(int[] nums) {
        //以nums[i]结尾的最大子数组乘积
        int dp[] = new int[nums.length];
        int dp_[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
            dp_[i] = nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] * nums[i], Math.max(dp[i], dp_[i - 1] * nums[i]));
            dp_[i] = Math.min(dp[i - 1] * nums[i], Math.min(dp_[i], dp_[i - 1] * nums[i]));
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        //[2,3,-2,0,4,-1]
        int[] nums = {-1, -2, -9, -6};
        System.out.println(new _152().maxProduct(nums));
    }
}
