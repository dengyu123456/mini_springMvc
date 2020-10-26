package com.dy.leetcode._组合问题;

import java.util.*;

//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
//说明：解集不能包含重复的子集。
//
//示例:
//
//输入: [1,2,2]
//输出:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/subsets-ii
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _90NO {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> pathList = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subsets(nums, 0);
       // res.add(new ArrayList<>());
        return res;
    }

    public void subsets(int[] nums, int minIndex) {
        res.add(new ArrayList<>(pathList));
        Set<Integer> set = new HashSet<>();
        for (int i = minIndex; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            pathList.add(nums[i]);
            subsets(nums, i + 1);
            pathList.remove(pathList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,4,4,1,4};
        new _90NO().subsetsWithDup(nums);
    }

}
