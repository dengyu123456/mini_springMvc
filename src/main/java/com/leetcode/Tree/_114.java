package com.leetcode.Tree;

public class _114 {

    public void flatten(TreeNode node) {

        if (node == null) return;
        //flatten(node.left);
        if (node.left != null) {
            if (node.right == null) {
                node.right = node.left;
            } else {
                TreeNode temp = node.right;
                node.right = node.left;
                TreeNode left = node.left;
                while (left.right != null) {
                    left = left.right;
                }
                left.right = temp;
            }
        }
        node.left = null;
        flatten(node.right);
    }

    public static void main(String[] args) {
        //Integer nums[] = {5, 4, 6, null, null, 3, 7};
        Integer nums[] = {0};
        TreeNode treeNode = TreeNodeUtil.createTreeNode(nums);
        new _114().flatten(treeNode);
        System.out.println("0000000000");
    }

}
