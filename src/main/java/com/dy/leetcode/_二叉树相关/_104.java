package com.dy.leetcode._二叉树相关;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 */
public class _104 {
    public int maxDepth(TreeNode root) {
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
            if (poll.left != null) {
                queue.add(poll.left);
                map.put(poll.left, map.get(poll) + 1);
            }
            if (poll.right != null) {
                queue.add(poll.right);
                map.put(poll.right, map.get(poll) + 1);
            }
            if (queue.isEmpty()) {
                return map.get(poll);
            }
        }
        return count;
    }


}
