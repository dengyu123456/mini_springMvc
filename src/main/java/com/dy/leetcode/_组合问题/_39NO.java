package com.dy.leetcode._组合问题;
//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//candidates 中的数字可以无限制重复被选取。
//
//说明：
//
//所有数字（包括 target）都是正整数。
//解集不能包含重复的组合。 
//示例 1：
//
//输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
//示例 2：
//
//输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/combination-sum
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _39NO {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> pathList = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0);
        return res;
    }

    public void combinationSum(int[] candidates, int target, int minIndex) {

        for (int i = minIndex; i < candidates.length; i++) {
            //如果大于target，则退出
            if (candidates[i] > target) {
                return;
            }
            if (candidates[i] == target) {
                pathList.add(candidates[i]);
                List<Integer> list = new ArrayList<>();
                list.addAll(pathList);
                res.add(list);
                pathList.remove(pathList.size() - 1);
            }
            if (candidates[i] < target) {
                pathList.add(candidates[i]);
                combinationSum(candidates, target - candidates[i], i);
                pathList.remove(pathList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        new _39NO().combinationSum(nums, 7);
    }
}
