package com.leetcode.Tree;

public class _669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        TreeNode head = new TreeNode(-1);
        head.right = root;
        dfs(root, head, false, low, high);
        return head.right;
    }

    public void dfs(TreeNode root, TreeNode preNode, boolean isLeft, int low, int high) {
        if (root == null) return;
//        if (root.val<low)dfs(root.left, root, true, low, high);
//        if (root.val>high)dfs(root.right, root, false, low, high);
        dfs(root.left, root, true, low, high);
        dfs(root.right, root, false, low, high);
        if (root.val < low || root.val > high) {
            //如果找到了，删除该节点
            if (root.right != null && root.left == null) {
                if (isLeft) {
                    preNode.left = root.right;
                } else {
                    preNode.right = root.right;
                }
//                root = root.right;
                return;
            }
            if (root.left != null && root.right == null) {
                if (isLeft) {
                    preNode.left = root.left;
                } else {
                    preNode.right = root.left;
                }
                return;
            }
            if (root.left == null && root.right == null) {
                if (isLeft) {
                    preNode.left = null;
                } else {
                    preNode.right = null;
                }
                return;
            }
            //记录原始的左右节点
            TreeNode left = root.left;
            TreeNode right = root.right;
            if (isLeft) {
                preNode.left = right;
            } else {
                preNode.right = right;
            }
            while (right.left != null) {
                right = right.left;
            }
            right.left = left;
            return;
        }

    }

    public static void main(String[] args) {
        Integer nums[] = {1,0,2};
        TreeNode treeNode = TreeNodeUtil.createTreeNode(nums);
        new _669().trimBST(treeNode, 1, 2);
    }
}
