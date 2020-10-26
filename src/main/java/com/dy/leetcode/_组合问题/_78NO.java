package com.dy.leetcode._组合问题;

import java.util.ArrayList;
import java.util.List;

//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
//说明：解集不能包含重复的子集。
//
//示例:
//
//输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/subsets
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _78NO {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> pathList = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        subsets(nums, 0);
        return res;
    }

    public void subsets(int[] nums, int minIndex) {
        res.add(new ArrayList<>(pathList));
        for (int i = minIndex; i < nums.length; i++) {
            pathList.add(nums[i]);
            subsets(nums, i + 1);
            pathList.remove(pathList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        new _78NO().subsets(nums);
    }
}
