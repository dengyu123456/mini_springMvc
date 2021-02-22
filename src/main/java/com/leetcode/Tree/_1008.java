package com.leetcode.Tree;

public class _1008 {
    //数组左边第一个
    boolean vist[];

    public TreeNode bstFromPreorder(int[] preorder) {
        vist = new boolean[preorder.length];
        if (preorder == null || preorder.length <= 0) return null;
        vist[0] = true;
        TreeNode treeNode = new TreeNode(preorder[0]);
        dfs(preorder, 1, preorder.length - 1, treeNode);
        return treeNode;
    }

    //定义
    public void dfs(int[] nums, int le, int ri, TreeNode root) {
        if (root == null) return;
        if (le <= 0 || ri >= nums.length || le > ri) return;
        int min = le, max = ri;
        TreeNode left = null, right = null;
        for (int i = le; i <= ri && !vist[i]; i++) {
            if (left != null && right != null) {
                break;
            }
            if (nums[i] < root.val && left == null) {
                left = new TreeNode(nums[i]);
                vist[i] = true;
                root.left = left;
                min = i + 1;
            }
            if (nums[i] > root.val && right == null) {
                right = new TreeNode(nums[i]);
                vist[i] = true;
                max = i - 1;
                root.right = right;
            }
        }
        dfs(nums, min, max, left);
        dfs(nums, max+2, ri, right);
    }

    public static void main(String[] args) {
        int[] nums = {8, 5, 1, 7, 10, 12};
        new _1008().bstFromPreorder(nums);

    }
}
