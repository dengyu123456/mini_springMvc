package com.dy.leetcode._动态规划;

//偷第一个，不能偷第二个
public class _213NO {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0],nums[1]);
        }
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < nums.length - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        int a = dp[nums.length - 2];

        int dp2[] = new int[nums.length];
        dp2[1] = nums[1];
        dp2[2] = Math.max(dp2[1], nums[2]);
        for (int i = 3; i < nums.length; i++) {
            dp2[i] = Math.max(dp2[i - 2] + nums[i], dp2[i - 1]);
        }
        int b = dp2[nums.length - 1];
        return Math.max(a, b);
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1};
        new _213NO().rob(nums);
    }
}
