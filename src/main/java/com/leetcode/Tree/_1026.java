package com.leetcode.Tree;


public class _1026 {

//    //暴力解法
//    int max = 0;
//
//    public int maxAncestorDiff(TreeNode root) {
//        dfs(root);
//        return max;
//    }
//
//    public void dfs(int val, TreeNode root) {
//        if (root == null) return;
//        max = Math.max(Math.abs(val - root.val), max);
//        dfs(val, root.left);
//        dfs(val, root.right);
//    }
//
//    public void dfs(TreeNode root) {
//        if (root == null) return;
//        dfs(root.val, root.left);
//        dfs(root.val, root.right);
//        dfs(root.left);
//        dfs(root.right);
//    }


    //记录一下递归的写法，无外乎
    // 1、设计清楚递归方法的“方法参数”、“返回值”两个东西
    // 2、明确函数干什么的，状态怎么转移 上一步到下一步的转移
    // 3、定义清楚“方法参数”、“返回值”以及一个成员变量
    //第二种解法：记录每条路径下最大最小值，当到达叶子节点时更新差值
    int ans = 0;

    public int maxAncestorDiff(TreeNode root) {
        dfs(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
        return ans;
    }

    private void dfs(TreeNode root, int min, int max) {
        if (root == null) return;
        if (root.val > max) {
            max = root.val;
        }
        if (root.val < min) {
            min = root.val;
        }
        if (root.left == null && root.right == null) {
            ans = Math.max(Math.abs(min - max), ans);
        }
        dfs(root.left, min, max);
        dfs(root.right, min, max);
    }

}
