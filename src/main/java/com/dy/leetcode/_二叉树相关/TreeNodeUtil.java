package com.dy.leetcode._二叉树相关;

public class TreeNodeUtil {
    public static TreeNode createTreeNode(Integer[] array){
        TreeNode root = createTreeNode(array, 1);
        return root;
    }

    private static TreeNode createTreeNode(Integer[] array, int index) {
        if(index > array.length){
            return null;
        }
        Integer value = array[index - 1];
        if(value == null){
            return null;
        }
        TreeNode node = new TreeNode(value);
        node.left = createTreeNode(array, index * 2);
        node.right = createTreeNode(array, index * 2 + 1);
        return node;
    }
}
