package com.dy.leetcode._组合问题;

import java.util.*;

//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//candidates 中的每个数字在每个组合中只能使用一次。
//
//说明：
//
//所有数字（包括目标数）都是正整数。
//解集不能包含重复的组合。 
//示例 1:
//
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
//示例 2:
//
//输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/combination-sum-ii
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _40NO {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> pathList = new ArrayList<>();
//    //访问过的索引
//    boolean visitIndex[] = null;
//    boolean visitNum[] = null;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0);
        return res;
    }

    public void combinationSum(int[] candidates, int target, int minIndex) {
        Set<Integer> set = new HashSet<>();
        for (int i = minIndex; i < candidates.length; i++) {
            if (set.contains(candidates[i])) {
                continue;
            } else {
                set.add(candidates[i]);
            }
            if (candidates[i] > target) {
                continue;
            }
            if (candidates[i] == target) {
                pathList.add(candidates[i]);
                res.add(new ArrayList<>(pathList));
                pathList.remove(pathList.size() - 1);
            }
            if (candidates[i] < target) {
                pathList.add(candidates[i]);
                combinationSum(candidates, target - candidates[i], i + 1);
                pathList.remove(pathList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        new _40NO().combinationSum2(nums, 8);
    }
}
