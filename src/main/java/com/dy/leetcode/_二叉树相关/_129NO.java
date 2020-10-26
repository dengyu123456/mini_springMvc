package com.dy.leetcode._二叉树相关;

import java.util.ArrayList;
import java.util.List;

public class _129NO {
    List<Integer> res = new ArrayList<>();
    //存储路径
    List<Integer> pathList = new ArrayList<>();

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        pathList.add(root.val);
        hasPathSum(root);
        int count = 0;
        for (Integer i : res) {
            count = count + i;
        }
        return count;
    }

    public void hasPathSum(TreeNode root) {

        //递归终止条件（是叶子节点）且sum=当前节点的val；
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            //这里加入res
//            ArrayList<Integer> resList = new ArrayList<>();
//            resList.addAll(pathList);
//            res.add(resList);
            String str = "";
            for (Integer item : pathList) {
                str = str + item;
            }
            res.add(Integer.parseInt(str));
            return;
        }
        if (root.left != null) {
            pathList.add(root.left.val);
            hasPathSum(root.left);
            pathList.remove(pathList.size() - 1);
        }
        if (root.right != null) {
            pathList.add(root.right.val);
            hasPathSum(root.right);
            pathList.remove(pathList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3};
        TreeNode treeNode = TreeNodeUtil.createTreeNode(nums);

    }
}
