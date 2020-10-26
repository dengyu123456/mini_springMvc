package com.dy.leetcode._渲染问题;

//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
//
//找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
//
//示例:
//
//X X X X
//X O O X
//X X O X
//X O X X
//运行你的函数后，矩阵变为：
//
//X X X X
//X X X X
//X X X X
//X O X X
//解释:
//
//被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/surrounded-regions
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

//这道题以后再做
public class _130NO {
    boolean[][] visit = null;
    static int[][] a = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }
        visit = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (visit[i][j]) {
                    continue;
                }
                pathFinding(board, i, j);
            }
        }
    }

    public boolean pathFinding(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }

        if (board[i][j] == 'X'||(visit[i][j]&&board[i][j]=='O')) {
            return true;
        }
//        if (visit[i][j]){
//            return false;
//        }
//        if (board[i][j] == 'X') {
//            return true;
//        }
        visit[i][j] = true;
        if (board[i][j] == 'O') {
            if (isX(board, i, j)) {
                board[i][j] = 'X';
                return true;
            }
        }
        return false;
    }

    public boolean isX(char[][] board, int i, int j) {
        for (int m = 0; m < a.length; m++) {
            if (pathFinding(board, i + a[m][0], j + a[m][1]) == false) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
//        char[][] board = {
//                {'O', 'O', 'O', 'O'},
//                {'O', 'O', 'O', 'O'},
//                {'O', 'O', 'O', 'O'},
//        };
        //[["O","O","O","O","X","X"],
        // ["O","O","O","O","O","O"],
        // ["O","X","O","X","O","O"],
        // ["O","X","O","O","X","O"],
        // ["O","X","O","X","O","O"],
        // ["O","X","O","O","O","O"]]
//        char[][] board = {
//                {'O', 'O', 'O', 'O', 'X', 'X'},
//                {'O', 'O', 'O', 'O', 'O', 'O'},
//                {'O', 'X', 'O', 'X', 'O', 'O'},
//                {'O', 'X', 'O', 'O', 'X', 'O'},
//                {'O', 'X', 'O', 'X', 'O', 'O'},
//                {'O', 'X', 'O', 'O', 'O', 'O'},
//        };
        new _130NO().solve(board);
    }
}

