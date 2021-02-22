package com.leetcode.Tree;

public class _783 {
    int min = Integer.MAX_VALUE;
    int pre = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return min;

    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        min = Math.min(min, Math.abs(pre - root.val));
        pre = root.val;
        dfs(root.right);
    }

    public static void main(String[] args) {
        Integer[] nums = {96, 12, null, null, 13, null, 52, 29, null, null, null};
        TreeNode treeNode = TreeNodeUtil.createTreeNode(nums);
        new _783().minDiffInBST(treeNode);


    }
}
