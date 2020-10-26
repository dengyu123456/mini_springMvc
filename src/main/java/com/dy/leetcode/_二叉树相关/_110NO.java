package com.dy.leetcode._二叉树相关;

import java.lang.management.PlatformLoggingMXBean;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

//给定一个二叉树，判断它是否是高度平衡的二叉树。
//
//本题中，一棵高度平衡二叉树定义为：
//
//一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
//
//示例 1:
//
//给定二叉树 [3,9,20,null,null,15,7]
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//返回 true 。
//
//示例 2:
//
//给定二叉树 [1,2,2,3,3,null,null,4,4]
//
//       1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
//返回 false 。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/balanced-binary-tree
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _110NO {
    //递归判断左右子树是否是BST
    boolean isBst = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        height(root);
        return isBst;
    }

    private int height(TreeNode root) {
        //递归终止条件
        if (root == null) {
            return 0;
        }

        int leHeight = height(root.left);
        int riHeight = height(root.right);
        //如果差值大于1
        if ((Math.abs(leHeight - riHeight)) > 1) {
            isBst = false;
        }
        return Math.max(leHeight, riHeight) + 1;
    }
}
