package com.leetcode.Offer;

import java.util.Arrays;

public class _03 {
//    public int findRepeatNumber(int[] nums) {
//        if(nums == null || nums.length ==0) return -1;
//        int m[] = new int[100001];
//        for (int i = 0; i < nums.length; i++) {
//            m[nums[i]] = m[nums[i]] + 1;
//            if (m[nums[i]] == 2) return nums[i];
//        }
//        return 0;
//    }

    public int findRepeatNumber(int[] nums) {
        // 1. 初始化一个数组
        int[] bucket = new int[nums.length];
      Arrays.fill(bucket,-1);
        for (int i = 0; i < nums.length; i++) {
            // 2. 判断当前元素是否已经存在
            if (bucket[nums[i]] != -1) {
                // 如果存在，则直接返回
                return nums[i];
            }
            // 否则的话，将当前元素作为索引，当前元素的下标作为值，填入数组中，
            // 方便后续的查找判重
            bucket[nums[i]] = i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 10000, 2};
        System.out.println(new _03().findRepeatNumber(nums));
    }
}
