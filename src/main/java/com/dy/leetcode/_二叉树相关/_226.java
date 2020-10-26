package com.dy.leetcode._二叉树相关;

/**
 * 翻转一棵二叉树。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 输出：
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 * <p>
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 */
public class _226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree1(root);
        return root;
    }

    public void invertTree1(TreeNode root) {
        if (root == null) {
            return;
        }
        invertTree1(root.left);
        invertTree1(root.right);
        TreeNode tempNode=root.right;
        root.right=root.left;
        root.left=tempNode;
    }

//    public static void main(String[] args) {
//        Integer
//        TreeNodeUtil.createTreeNode()
//        new _226().invertTree()
//    }
}
