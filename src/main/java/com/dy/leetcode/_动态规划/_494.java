package com.dy.leetcode._动态规划;

import java.util.ArrayList;
import java.util.List;

public class _494 {
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        findTargetSumWays(nums, S, 0,0);
        return count;
    }

    public void findTargetSumWays(int[] nums, int S, int index, int time) {
        if (index == nums.length && S == 0) {
            count++;
        }
        if (index>nums.length-1){
            return;
        }
            findTargetSumWays(nums, S - nums[index], index + 1, time);
            findTargetSumWays(nums, S + nums[index], index + 1, time);
    }

    public static void main(String[] args) {
        int nums[] = {1, 1, 1, 1, 1};
        new _494().findTargetSumWays(nums, 3);
    }
}
