package com.dy.leetcode._渲染问题;

//给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//
//单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
// 
//
//示例:
//
//board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false
// 
//
//提示：
//
//board 和 word 中只包含大写和小写英文字母。
//1 <= board.length <= 200
//1 <= board[i].length <= 200
//1 <= word.length <= 10^3
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/word-search
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _79NO {
    boolean isHave = false;
    static int[][] a = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    boolean[][] visit = null;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return false;
        }
        char[] chars = word.toCharArray();
        visit = new boolean[board.length][board[0].length];
        if(chars.length>board.length*board[0].length){
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (isHave){
                    return true;
                }
                if (!visit[i][j] && board[i][j] == chars[0]) {
                    dfs(board, chars, i, j, 0);
                }
            }
        }
        return isHave;
    }

    public void dfs(char[][] board, char[] chars, int i, int j, int index) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || index > chars.length - 1) {
            return;
        }
        if (visit[i][j]) {
            return;
        }
        if (index == chars.length - 1 && board[i][j] == chars[index]) {
            isHave = true;
            return;
        }
        if (board[i][j] == chars[index]) {
            if (isHave){
                return;
            }
            for (int m = 0; m < a.length; m++) {
                visit[i][j] = true;
                dfs(board, chars, i + a[m][0], j + a[m][1], index + 1);
                visit[i][j] = false;
            }
        }
    }
}














