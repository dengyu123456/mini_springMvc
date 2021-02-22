package com.leetcode.Tree;

import sun.security.krb5.internal.rcache.DflCache;

public class _998 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val > root.val) {
            TreeNode treeNode = new TreeNode(val);
            treeNode.left = root;
            return treeNode;
        }
        dfs(root, val, null);
        return root;
    }

    //val大于当前节点，则prenode。right=val val左=root
    //如果小于继续往下递归找右节点当为null时pre。right=val
    public void dfs(TreeNode treeNode, int val, TreeNode preNode) {
        if (treeNode == null) {
            TreeNode treeNode1 = new TreeNode(val);
            preNode.right = treeNode1;
            return;
        }
        if (val > treeNode.val) {
            TreeNode treeNode1 = new TreeNode(val);
            preNode.right = treeNode1;
            treeNode1.left = treeNode;
            return;
        }
        dfs(treeNode.right, val, treeNode);
    }
}
