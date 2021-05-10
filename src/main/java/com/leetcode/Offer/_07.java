package com.leetcode.Offer;

import java.util.HashSet;
import java.util.Set;

public class _07 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    //前序遍历第一个节点就是根节点
    public TreeNode build(int[] preorder, int[] inorder, int preStart, int preEnd, int inoStart, int inoEnd) {
        if (preStart > preEnd) return null;
        //根节点在中序遍历当中的节点
        int rootVal = preorder[preStart];
        int index = -1;
        for (int i = inoStart; i <= inoEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        int leftSize = index - inoStart;
        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = build(preorder, inorder, preStart + 1, preStart + leftSize, inoStart, index - 1);
        root.right = build(preorder, inorder, preStart + leftSize + 1, preEnd, index + 1, inoEnd);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {3,9,20,15,7};
        int[] ino = {9,3,15,20,7};
        new _07().buildTree(pre,ino);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
