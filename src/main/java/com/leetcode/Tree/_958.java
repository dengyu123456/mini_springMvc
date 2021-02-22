package com.leetcode.Tree;

import javafx.scene.layout.BorderImage;

public class _958 {


    private int min = Integer.MAX_VALUE;
    private int max = 0;

    public boolean isCompleteTree(TreeNode root) {
        dfs(root, 1);
        return min == max + 1;
    }
    //定义  状态  选择
    //定义：函数更新每个节点的编号 max记录不为空的节点，min记录第一次为空的节点的编号
    //先序遍历保证最开始遍历的节点一定在最左边满足满二叉树的定义
    //1、当前root是父节点的左节点而且是最后一个节点，右节点是空 （满二叉树）
    //2、当前root是父节点的左节点而且右节点不为空 右节点是最后一个节点 （min没有更新） （满二叉树）
    //3、遇到第一个空节点不是最后一个节点，更新min值，这个时候后面有节点的话max必然大于min （不是满二叉树）

    //状态：node、num（节点、编号） 记录遍历到第几个节点  右节点数-左节点数=1
    //如果父节点的右节点为空，则会记录一个虚假的右节点数min  这个时候只需要判断max（左）+1=min；

    //选择：根据满二叉树定义，第一个为空的节点min一定会记录，后面只要还有节点max必然大于min，就不
    //满足max+1=min的定义
    private void dfs(TreeNode root, int num) {
        if (root == null) {
            if (min > num) {
                min = num;
            }
            return;
        }
        if (max < num) {
            max = num;
        }
        dfs(root.left, num * 2);
        dfs(root.right, num * 2 + 1);
    }

    public static void main(String[] args) {
        Integer[] num = {1, 2};
        TreeNode treeNode = TreeNodeUtil.createTreeNode(num);
        new _958().isCompleteTree(treeNode);
    }
}
