package com.leetcode.Tree;

import javax.naming.ldap.LdapReferralException;
import java.util.LinkedList;
import java.util.List;

public class _98 {

    List<Integer> nums = new LinkedList();

    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean validate(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return  validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

//    public boolean isValidBST(TreeNode root) {
//        LDR(root);
//        if (nums.size() == 1) {
//            return true;
//        }
//        for (int i = 1; i < nums.size(); i++) {
//            if (nums.get(i) <= nums.get(i - 1)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public void LDR(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        LDR(root.left);
//        nums.add(root.val);
//        LDR(root.right);
//    }


    public static void main(String[] args) {
        Integer nums[] = {5, 4, 6, null, null, 3, 7};
//        Integer nums[] = {2,1,3};
        TreeNode treeNode = TreeNodeUtil.createTreeNode(nums);
        new _98().isValidBST(treeNode);

    }
}
