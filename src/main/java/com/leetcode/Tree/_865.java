package com.leetcode.Tree;

import java.util.HashMap;
import java.util.Map;

public class _865 {
    Integer max = 0;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        getLv(root, 1);
        return dfs(root,1);
    }

    //第一次深度遍历记录下来所有节点的最大深度
    public void getLv(TreeNode root, Integer lv) {
        if (root == null) return;
        getLv(root.left, lv + 1);
        getLv(root.right, lv + 1);
        max = Math.max(lv, max);
    }

    public TreeNode dfs(TreeNode root,int lv) {
        if (root == null) return null;
        if (lv == max) return root;
        TreeNode left = dfs(root.left,lv+1);
        TreeNode right = dfs(root.right,lv+1);
        if (right != null && left != null) return root;
        if (right == null && left != null) return left;
        if (right != null && left == null) return right;
        return null;
    }

    public static void main(String[] args) {
        Integer nums[] = {3,5,1,6,2,0,8,null,null,null,4};
        TreeNode treeNode = TreeNodeUtil.createTreeNode(nums);
        new _865().subtreeWithAllDeepest(treeNode);
    }
}
