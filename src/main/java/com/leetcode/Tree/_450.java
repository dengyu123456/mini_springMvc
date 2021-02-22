package com.leetcode.Tree;

public class _450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode head = new TreeNode(-1);
        head.right = root;
        dfs(root, key, head, false);
        return head.right;
    }

    public void dfs(TreeNode root, int key, TreeNode preNode, boolean isLeft) {
        if (root == null) return;
        if (key == root.val) {
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
        if (key < root.val) dfs(root.left, key, root, true);
        if (key > root.val) dfs(root.right, key, root, false);
    }

    public static void main(String[] args) {
        Integer nums[] = {5, 3, 6, 2, 4, null, 7};
        TreeNode treeNode = TreeNodeUtil.createTreeNode(nums);
        new _450().deleteNode(treeNode, 2);
    }
}
