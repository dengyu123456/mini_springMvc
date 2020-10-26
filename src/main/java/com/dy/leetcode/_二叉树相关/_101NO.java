package com.dy.leetcode._二叉树相关;

import java.lang.management.BufferPoolMXBean;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 *  
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 *  
 * <p>
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 *  
 * <p>
 * 进阶：
 * <p>
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//未完成
public class _101NO {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if ((root.left == null && root.right != null) || (root.right == null && root.left != null)) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left.val != root.right.val) {
            return false;
        }
        return isSymmetric(root.left, root.right);
    }

    //比较两颗子树的左节点是否等于右节点
    public boolean isSymmetric(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (q == null && p != null)) return false;
        if (p.left == null && q.right == null && p.right == null && q.left == null) return true;
        if (p.left == null && q.right != null) {
            return false;
        }
        if (p.right == null && q.left != null) {
            return false;
        }
        if (q.right==null&&p.left!=null){
            return false;
        }if (q.left==null&&p.right!=null){
            return false;
        }
        if (p.left != null && q.right != null) {
            if (p.left.val == q.right.val) return true;
            else {
                return false;
            }
        }
        if (p.right != null && q.left != null) {
            if (p.right.val == q.left.val) {
                return true;
            } else {
                return false;
            }
        }

        return isSymmetric(p.left, p.right) && isSymmetric(q.left, q.right);
    }

    public static void main(String[] args) {
        Integer[] root = {2, 3, 3, 4, 5, 5};
        TreeNode treeNode = TreeNodeUtil.createTreeNode(root);
        System.out.println(new _101NO().isSymmetric(treeNode));

    }
}
