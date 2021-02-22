package com.leetcode.Tree;

public class _814 {
    public TreeNode pruneTree(TreeNode root) {
        if (root==null){
            return null;
        }
        boolean dfs = dfs(root);
        if (dfs){
            return null;
        }
        return root;
    }
    public boolean dfs(TreeNode root) {
        if (root == null) return true;
        boolean left = dfs(root.left);
        boolean right = dfs(root.right);
        if (left) {
            root.left = null;
        }
        if (right) {
            root.right = null;
        }
        return root.val == 0 && left && right;
    }

    public static void main(String[] args) {
        Integer []nums={0,0};
        TreeNode treeNode = TreeNodeUtil.createTreeNode(nums);
        new _814().pruneTree(treeNode);
    }
}
