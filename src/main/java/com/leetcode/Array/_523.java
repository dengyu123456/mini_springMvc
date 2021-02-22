package com.leetcode.Array;

import java.text.DateFormatSymbols;

public class _523 {
    boolean flag = false;
    //数组大小
    int count = 0;

    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        k = Math.abs(k);
        //数组求和
        int sum = 0;
        for (int i : nums) {
            sum = sum + i;
        }
        if (sum < k) {
            return false;
        }
        if (k == 0) {
            check(nums, 0, k,0);
        } else {
            int n = sum / k;
            for (int i = 1; i <= n; i++) {
                if (flag) {
                    return flag;
                }
                check(nums, 0, i * k,0);
            }
        }
        return flag;

    }

    private void check(int[] nums, int index, int tager,int preIndex) {
        if (flag) return;
        if (tager == 0&&index-preIndex==1) {
            flag = true;
            return;
        }
        if (index < 0 || index >= nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {

            check(nums, i + 1, tager - nums[i],i);

        }
    }

    public static void main(String[] args) {
//        int[] nums = {23, 2, 4, 6, 7};
//        new _523().checkSubarraySum(nums, 6);

        int[] nums = {0,1,0};
        new _523().checkSubarraySum(nums, 0);
    }
}
