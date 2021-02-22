package com.leetcode.Tree;

public class _230 {
    private int a;
    private int b;

    public int kthSmallest(TreeNode root, int k) {
        a = 0;
        LDR(root, k);
        return b;
    }

    private void LDR(TreeNode node, int k) {
        //为什么这里不能正常返回
//  if(a==-1){
//            return;
//        }
        if (node == null) return ;
        LDR(node.left, k);
        if(a==-1){
            return;
        }
        a++;
        if (a == k) {
            a=-1;
            b= node.val;
        }
         LDR(node.right, k);
    }

    public static void main(String[] args) {
        Integer nums1[] = {3, 1, 4, null, 2};
        TreeNode treeNode = TreeNodeUtil.createTreeNode(nums1);
        new _230().kthSmallest(treeNode, 1);
    }
}
