package com.dy.leetcode._渲染问题;

//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
//岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
//
//此外，你可以假设该网格的四条边均被水包围。
//
// 
//
//示例 1:
//
//输入:
//[
//['1','1','1','1','0'],
//['1','1','0','1','0'],
//['1','1','0','0','0'],
//['0','0','0','0','0']
//]
//输出: 1
//示例 2:
//
//输入:
//[
//['1','1','0','0','0'],
//['1','1','0','0','0'],
//['0','0','1','0','0'],
//['0','0','0','1','1']
//]
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/number-of-islands
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _200NO {
    boolean[][] visit = null;
    int count = 0;
    static int[][] a = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return count;
        }
        visit = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visit[i][j] && grid[i][j] == 49) {
                    count++;
                    pathFinding(grid, i, j);
                }
            }
        }
        return count;
    }

    private void pathFinding(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        if (visit[i][j]) {
            return;
        }
        visit[i][j] = true;
        //寻路，查看上下左右是否可以链接，可以则链接起来进入下一次寻路递归
        for (int m = 0; m < a.length; m++) {
            if (grid[i][j] == 49) {
                pathFinding(grid, i + a[m][0], j + a[m][1]);
            }
        }

    }

    public static void main(String[] args) {
//        char[][] nums = {
//                {'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'}
//        };

        //[["1","1","0","0","0"],["1","1","0","0","0"],["0","0","1","0","0"],["0","0","0","1","1"]]
//        char[][] nums = {
//                {'1', '1', '0', '0', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '1', '0', '0'},
//                {'0', '0', '0', '1', '1'}
//        };
        char[][] nums = {
        };
        System.out.println(new _200NO().numIslands(nums));
    }
}
