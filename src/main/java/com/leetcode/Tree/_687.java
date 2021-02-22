package com.leetcode.Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _687 {

    Set<Integer> list = new HashSet<>();

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        dfs(root, null);
        int max = 0;
        for (Integer i : list) {
            max = Math.max(i, max);
        }
        return max;
    }

    //相同路径=left的相同节点路径+right的相同节点路径
    public int dfs(TreeNode root, TreeNode preNode) {
        if (root == null) return 0;
        int left = dfs(root.left, root);
        int right = dfs(root.right, root);
        //root节点的路径=left+right
//        list.add(left + right);
        if (preNode != null && root.val == preNode.val) {
            list.add(Math.max(left, right) + 1);
            return Math.max(left, right) + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        //[5,4,5,1,1,5,5,null,null,null,null,null,5,5,5]
        Integer[] nums = {5,4,5,1,1,5,5,null,null,null,null,null,5,5,5};
        TreeNode treeNode = TreeNodeUtil.createTreeNode(nums);
        new _687().longestUnivaluePath(treeNode);
    }
}
