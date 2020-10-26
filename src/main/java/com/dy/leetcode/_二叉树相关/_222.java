package com.dy.leetcode._二叉树相关;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 给出一个完全二叉树，求出该树的节点个数。
 * <p>
 * 说明：
 * <p>
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * 1
 * /  \
 * 2   3
 * / \  /
 * 4  5 6
 * <p>
 * 输出: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _222 {
    //1解法广度优先遍历
//    public int countNodes(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        Queue<TreeNode> queue = new ConcurrentLinkedQueue<>();
//        queue.add(root);
//        int count = 0;
//        while (!queue.isEmpty()) {
//            TreeNode poll = queue.poll();
//            count++;
//            if (poll.left != null) {
//                queue.add(poll.left);
//            }
//            if (poll.right != null) {
//                queue.add(poll.right);
//            }
//        }
//        return count;
//    }

//    int lastCount = 0;
//    boolean falg = false;
//
//    //2、深度优先遍历
//    public int countNodes(TreeNode root) {
//        //遍历层级
//        int lv = -1;
//        if (root == null) {
//            return 0;
//        }
//        lastCountNodes(root);
//        while (root.left != null) {
//            root = root.left;
//            lv++;
//        }
//
//        if (lv < 0) {
//            return lastCount;
//        }
//        int count = 0;
//        for (int i = 0; i <= lv; i++) {
//            count = (1 << i) + count;
//        }
//        return count + lastCount;
//
//    }
//
//    //查找最后一层节点数量
//    public void lastCountNodes(TreeNode root) {
//        if (falg) {
//            return;
//        }
//        if (root.left == null && root.right == null) {
//            lastCount++;
//            return;
//        }
//        if (root.left != null && root.right == null) {
//            //当运行到这里，已经找到了最右边的最下层的节点
//            falg = true;
//            lastCount++;
//            return;
//        }
//        if (root.left != null) {
//            lastCountNodes(root.left);
//        }
//        if (root.right != null) {
//            lastCountNodes(root.right);
//        }
//    }
public int countNodes(TreeNode root) {
    if (root==null){
        return 0;
    }
    System.out.println(root.val);
    return countNodes(root.left)+countNodes(root.right)+1;
}
    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4,5,6};
        TreeNode root = TreeNodeUtil.createTreeNode(nums);
        new _222().countNodes(root);
    }
}
