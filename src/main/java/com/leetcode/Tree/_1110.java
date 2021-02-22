package com.leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

public class _1110 {

    List<TreeNode> list = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) return list;
        boolean falg = true;
        for (int i : to_delete) {
            if (root.val == i) {
                falg = false;
            }
        }
        if (falg) {
            list.add(root);
        }
        dfs(root, to_delete, null, true);

        return list;
    }

    public void dfs(TreeNode root, int[] to_delete, TreeNode preNode, boolean isLeft) {
        if (root == null) return;
        dfs(root.left, to_delete, root, true);
        dfs(root.right, to_delete, root, false);
        for (int i : to_delete) {
            if (root.val == i) {
                if (preNode != null) {
                    if (isLeft) {
                        preNode.left = null;
                    } else {
                        preNode.right = null;
                    }
                }
                if (root.left != null) list.add(root.left);
                if (root.right != null) list.add(root.right);
                break;
            }
        }
    }

}
