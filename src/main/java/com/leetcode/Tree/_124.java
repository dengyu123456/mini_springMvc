package com.leetcode.Tree;


public class _124 {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        max = Math.max(left + right+node.val, max);
        return Math.max(left, right) + node.val<0?0:Math.max(left, right) + node.val;
    }

    public static void main(String[] args) {
        Integer nums[] = {2,-1};
        TreeNode treeNode = TreeNodeUtil.createTreeNode(nums);
        new _124().maxPathSum(treeNode);
    }
}
