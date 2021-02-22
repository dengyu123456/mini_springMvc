package com.leetcode.Tree;

public class _654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        TreeNode dfs = dfs(nums, 0, nums.length - 1);
        return dfs;
    }

    public TreeNode dfs(int[] nums, int left, int right) {

        if (left > right || left < 0 || right >= nums.length) {
            return null;
        }
        int mid = -1;
        int max = Integer.MIN_VALUE;
        //mid为left-right当中最大值在的坐标
        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                mid = i;
            }
        }
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = dfs(nums, left, mid - 1);
        treeNode.right = dfs(nums, mid + 1, right);
        return treeNode;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        new _654().constructMaximumBinaryTree(nums);
    }
}
