package com.dy.leetcode._组合问题;

import java.util.ArrayList;
import java.util.List;

//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
//
//说明：
//
//所有数字都是正整数。
//解集不能包含重复的组合。 
//示例 1:
//
//输入: k = 3, n = 7
//输出: [[1,2,4]]
//示例 2:
//
//输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/combination-sum-iii
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _216NO {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> pathList = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        combinationSum(k, n, 1);
        return res;
    }

    public void combinationSum(int size, int target, int min) {
        for (int i = min; i <= 9; i++) {
            if (i > target) {
                return;
            }
            pathList.add(i);
            if (i == target && pathList.size() == size) {
                res.add(new ArrayList<>(pathList));
            }
            if (i < target) {
                combinationSum(size, target - i, i + 1);
            }
            pathList.remove(pathList.size() - 1);
        }
    }

    public static void main(String[] args) {
        new _216NO().combinationSum3(10, 9);
    }
}
