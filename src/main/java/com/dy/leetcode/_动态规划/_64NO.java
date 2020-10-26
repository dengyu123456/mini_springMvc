package com.dy.leetcode._动态规划;

import java.security.interfaces.RSAKey;
import java.util.ArrayList;
import java.util.List;

//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
//说明：每次只能向下或者向右移动一步。
//
//示例:
//
//输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/minimum-path-sum
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _64NO {
    //路径
    int[][] a = {{1, 0}, {0, 1}};
    //List<Integer> res = new ArrayList<>();
    int min = Integer.MAX_VALUE;
    public int minPathSum(int[][] grid) {
        dfs(grid, 0, 0, 0);

//        for (Integer i : res) {
//            if (i < min) {
//                min = i;
//            }
//        }
        return min;
    }

    public void dfs(int[][] grid, int i, int j, int previous) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        System.out.println("i=" + i + "j=" + j + "  " + previous);
        if (i == grid.length - 1 && j == grid[0].length - 1) {
           if (previous + grid[i][j]<min){
               System.out.println("=============="); 
               min=previous + grid[i][j];
           }
            return;
        }
        for (int k = 0; k < a.length; k++) {
            if (grid[i][j] + previous>=min){
                continue;
            }
            dfs(grid, i + a[k][0], j + a[k][1], grid[i][j] + previous);
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 3, 1},
                        {1, 5, 1},
                        {4, 2, 1}};
        new _64NO().minPathSum(nums);
    }


}
