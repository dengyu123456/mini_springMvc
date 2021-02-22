package com.leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

public class _94 {
    List<Integer> resList = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return resList;
    }

    public void inorder(TreeNode root) {
        if (root!=null) {
            if (root.left != null)
                inorder(root.left);
                resList.add(root.val);
            if (root.right != null)
                inorder(root.right);
        }
    }
}
