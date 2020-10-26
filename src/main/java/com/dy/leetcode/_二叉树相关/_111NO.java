package com.dy.leetcode._二叉树相关;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最小深度  2.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _111NO {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 1;
        //广度优先

        Map<TreeNode, Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        map.put(root, count);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.left == null && poll.right == null) {
                return map.get(poll);
            }
            if (poll.left != null) {
                queue.add(poll.left);
                map.put(poll.left, map.get(poll) + 1);
            }
            if (poll.right != null) {
                queue.add(poll.right);
                map.put(poll.right, map.get(poll) + 1);
            }

        }
        return count;
    }
}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
