package com.dy.leetcode._二叉树相关;

import java.util.HashSet;
import java.util.Set;

public class _105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //set记录一下元素被放在了数组中
        Set<Integer> visitSet = new HashSet<>(preorder.length + 1);
        TreeNode resRoot = new TreeNode(preorder[0]);
        visitSet.add(preorder[0]);
        for (int i = 0; i < preorder.length; i++) {
            if (!visitSet.contains(preorder[i])) {
                resRoot.setLeft(new TreeNode(preorder[1]));
            }
        }
        return resRoot;
    }
}
