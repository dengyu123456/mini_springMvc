package com.dy.leetcode._动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
//
//相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
//
// 
//
//例如，给定三角形：
//
//[
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
//
// 
//
//说明：
//
//如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/triangle
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _120NO {
    public int minimumTotal(List<List<Integer>> triangle) {
        //定义： dp[][] 为上一层最小路径
        Integer dp[][] = new Integer[triangle.size()][triangle.get(triangle.size() - 1).size()];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                Integer a = dp[i - 1][j];
                int b = j - 1 < 0 ? dp[i - 1][j] : dp[i - 1][j - 1];
                if (a == null) {
                  dp[i][j]=b+triangle.get(i).get(j);
                  continue;
                }
                dp[i][j] = Math.min(a, b) + triangle.get(i).get(j);
            }
        }
        int min = Integer.MAX_VALUE;
        Integer res[] = dp[dp.length - 1];
        for (int i = 0; i < res.length; i++) {
            if (res[i] < min) {
                min = res[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] nums = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums[i].length; j++) {
                list.add(nums[i][j]);
            }
            lists.add(list);
        }
        new _120NO().minimumTotal(lists);

    }
}
