package com.dy.leetcode._动态规划;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _377NO {
    //    List<List<Integer>> res = new ArrayList<>();
//    List<Integer> pathList = new ArrayList<>();
    int count = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public int combinationSum4(int[] nums, int target) {
        map.put(0, 1);
        for (int i = 1; i <= target; i++) {
            combinationSum(nums, i);
            map.put(i, count);
            count = 0;
        }
        combinationSum(nums, target);
        return count;
    }

    public void combinationSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (target - nums[i] <0) {
                continue;
            }
            if (map.containsKey(target - nums[i])) {
                count = map.get(target - nums[i]) + count;
                continue;
            }
//            if (target - nums[i] == 0) {
//                count++;
//            }
            combinationSum(nums, target - nums[i]);
        }

    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        new _377NO().combinationSum4(nums, 32);
    }


}
