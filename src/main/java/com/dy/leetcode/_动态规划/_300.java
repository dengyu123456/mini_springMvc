package com.dy.leetcode._动态规划;

public class _300 {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] LIS = new int[nums.length];
        for (int i = 0; i < LIS.length; i++) {
            LIS[i] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int LISJ = 0;
                if (nums[j] < nums[i]) {
                    LISJ = LIS[j];
                }
                int LISK = 0;
                if (LISJ != 0) {
                    for (int k = i - 1; k >= 0; k--) {
                        if (nums[j] < nums[i] && nums[k] > nums[j] && nums[k] < nums[i]) {
                            if (LIS[k] > LISK)
                                LISK = LIS[k];
                        }
                    }
                }
                LIS[i] = max3(LISJ + 1, LISK + 1, LIS[i]);
                if (LISJ != 0 && LISK != 0) {
                    break;
                }
            }
        }
        int max = -1;
        for (int i = 0; i < LIS.length; i++) {
            if (LIS[i] > max) {
                max = LIS[i];
            }
        }
        return max;
    }

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 1, 2, 3, 4, 5, 6, 7};
        new _300().lengthOfLIS(nums);

    }
}
