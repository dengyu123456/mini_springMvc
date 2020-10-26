package com.dy.leetcode._动态规划;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;

public class _376 {

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //去掉前面重复的元素
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]){
                list.add(nums[i]);
            }
        } //预处理,去掉连续的重复的数
        int nums1[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums1[i] = list.get(i);
        }
        nums=nums1;
        if (nums.length == 1) {
            return 1;
        }
        //定义：wiggle是第i个元素的摆动序列的最大值
        int wiggle[] = new int[nums.length];

        //定义：falg[i]为true下一个元素为小于nums[i]
        Boolean falg[] = new Boolean[nums.length];
        if (nums[0] > nums[1]) {
            falg[0] = true;
        } else {
            falg[0] = false;
        }
        wiggle[0] = 1;
        if (wiggle[0] == wiggle[1]) {
            return 1;
        }
//        wiggle[1] = 2;
        for (int i = 1; i < nums.length; i++) {
            //找出第一个小于nums[i]的
            int less = 0;
            for (int j = i - 1; j >= 0 && less == 0; j--) {
                if (nums[j] < nums[i] && !falg[j]) {
                    less = wiggle[j] + 1;
                }
            }
            int than = 0;
            for (int j = i - 1; j >= 0 && than == 0; j--) {
                if (nums[j] > nums[i] && falg[j]) {
                    than = wiggle[j] + 1;
                }
            }
            if (less > than) {
                wiggle[i] = less;
                falg[i] = true;
            } else  {
                wiggle[i] = than;
                falg[i] = false;
            }
        }
//        int max = 0;
//        for (int i = 0; i < wiggle.length; i++) {
//            max = Math.max(wiggle[i], max);
//        }
        return wiggle[wiggle.length-1];
    }

    public static void main(String[] args) {
        int nums[] = {1,1,2,3,4,1,5,3,4,2,1};
        new _376().wiggleMaxLength(nums);
    }
}
