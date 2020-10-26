package com.dy.leetcode._排列相关;
//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
//示例:
//
//输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/permutations
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.List;

public class _46NO {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> pathList = new ArrayList<>();
    boolean visti[] = null;

    public List<List<Integer>> permute(int[] nums) {
        visti = new boolean[nums.length];
        permute1(nums);
        return res;
    }

    public void permute1(int[] nums) {
        if (pathList.size() == nums.length) {
            List<Integer> list = new ArrayList<>();
            list.addAll(pathList);
            res.add(list);
        }
        for (int i = 0; i < nums.length; i++) {
            if (visti[i]) {
                continue;
            }
            visti[i] = true;
            pathList.add(nums[i]);
            permute1(nums);
            pathList.remove(pathList.size() - 1);
            visti[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        new _46NO().permute(nums);
    }
}
