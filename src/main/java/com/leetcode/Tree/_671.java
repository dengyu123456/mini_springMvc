package com.leetcode.Tree;

public class _671 {
    int rootVal = 0;

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        rootVal = root.val;
        int dfs = dfs(root);
        if (dfs==rootVal){
            return -1;
        }
        return dfs;
    }
    public int dfs(TreeNode root) {
        if (root == null) return rootVal;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == rootVal && right == rootVal) {
            return root.val;
        }
        if (left != rootVal && right == rootVal) {
            return left;
        }
        if (left == rootVal && right != rootVal) {
            return right;
        }
        return Math.min(left, right);
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 1, 3, 1, 1, 3, 4, 3, 1, 1, 1, 3, 8, 4, 8, 3, 3, 1, 6, 2, 1};
        TreeNode treeNode = TreeNodeUtil.createTreeNode(nums);
        System.out.println(new _671().findSecondMinimumValue(treeNode));

    }
}
