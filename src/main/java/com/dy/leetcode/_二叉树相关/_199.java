package com.dy.leetcode._二叉树相关;
/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 * <p>
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//广度优先遍历出每一层的最后一个节点

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class _199 {

    public List<Integer> rightSideView(TreeNode root) {
        if (root==null){
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        //记录每一层的层数
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 0);
        int rank;
        while (!queue.isEmpty()) {
            //验证是否是当前层级的最后一个节点
            TreeNode poll = queue.poll();
            //当前层级
            rank = map.get(poll);
            if (queue.isEmpty() || map.get(queue.peek()) > rank) {
                list.add(poll.val);
            }
            if (poll.left != null) {
                queue.add(poll.left);
                map.put(poll.left, rank + 1);
            }
            if (poll.right != null) {
                queue.add(poll.right);
                map.put(poll.right, rank + 1);
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
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
