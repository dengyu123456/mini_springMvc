package com.dy.leetcode._二叉树相关;

//计算给定二叉树的所有左叶子之和。
//
//示例：
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/sum-of-left-leaves
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _404No {
    int count = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        sumOfLeftLeaves(root, false);
        return count;
    }

    public void sumOfLeftLeaves(TreeNode root, Boolean isLeft) {
        if (root == null) {
            return;
        }
        if (isLeft && root.left == null && root.right == null) {
            count = count + root.val;
        }
        sumOfLeftLeaves(root.left, true);
        sumOfLeftLeaves(root.right, false);
    }
}
