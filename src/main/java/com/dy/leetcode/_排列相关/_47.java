package com.dy.leetcode._排列相关;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _47 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> pathList = new ArrayList<>();
    boolean visti[] = null;

    public List<List<Integer>> permuteUnique(int[] nums) {
        visti=new boolean[nums.length];
        permute1(nums);
        return res;
    }

    public void permute1(int[] nums) {
        Set<Integer> visit = new HashSet<>();
        if (pathList.size() == nums.length) {
            List<Integer> list = new ArrayList<>();
            list.addAll(pathList);
            res.add(list);
        }
        for (int i = 0; i < nums.length; i++) {
            if (visti[i]) {
                continue;
            }
            if (visit.contains(nums[i])) {
                continue;
            } else {
                visti[i] = true;
                visit.add(nums[i]);
                pathList.add(nums[i]);
                permute1(nums);
                pathList.remove(pathList.size() - 1);
                visti[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1,1, 2};
        new _47().permuteUnique(nums);
    }
}
