package com.leetcode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _101 {
    List<Integer> nums = new ArrayList<>();

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return def(root.left, root.right);
    }

    public boolean def(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left==null&&right!=null){
            return false;
        }
        if (right==null&&left!=null){
            return false;
        }
        if (left.val == right.val && def(left.left, right.right) && def(left.right,right.left)) {
            return true;
        }
        return false;
    }

    public void LDR(TreeNode root) {
        if (root == null) {
            return;
        }
        LDR(root.left);
        nums.add(root.val);
        LDR(root.right);
    }

    public static void main(String[] args) {
        Integer nums1[] = {1,2,2,3,4,4,3};
//        Integer nums[] = {2,1,3};
        TreeNode treeNode = TreeNodeUtil.createTreeNode(nums1);
        _101 a = new _101();
        System.out.println(a.isSymmetric(treeNode));
    }
}
