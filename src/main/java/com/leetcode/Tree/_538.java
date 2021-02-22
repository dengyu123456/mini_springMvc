package com.leetcode.Tree;

import com.dy.threadDemo.threadPoolDemo.Priority;

import java.util.ArrayList;
import java.util.List;

public class _538 {

     int pre = 0;

    public TreeNode convertBST(TreeNode root) {
        RDL(root);
        return root;
    }

    public  void RDL(TreeNode node) {
        if (node == null) return;
        RDL(node.right);
        pre = pre + node.val;
        node.val = pre;
        RDL(node.left);
    }

    public static void main(String[] args) {
        Integer[] nums = {4,1,6,0,2,5,7,null,null,null,3,null,null,null,8};
        TreeNode treeNode = TreeNodeUtil.createTreeNode(nums);
        new _538().convertBST(treeNode);

    }
}
