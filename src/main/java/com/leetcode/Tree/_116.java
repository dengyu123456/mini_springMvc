package com.leetcode.Tree;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class _116 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        //第一种方法层序遍历  复杂度爆炸
        Queue<Node> queue = new ConcurrentLinkedQueue();
        //记录层级
        Map<Node, Integer> map = new HashMap<>();
        queue.add(root);
        map.put(root, 0);
        Node pre = root;
        Integer lv = 0;
        root.next = null;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (lv != 0) {
                if (map.get(poll) == lv && lv != 0) {
                    pre.next = poll;
                    pre = poll;
                } else {
                    pre.next = null;
                    pre = poll;
                    lv = map.get(poll);
                }
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
        return root;
    }

    static List<Integer>  nums = new ArrayList<>();

    //第二种方法深度遍历
    public void LRD(TreeNode node) {
        if (node == null) return;
        LRD(node.left);
        LRD(node.right);
        nums.add(node.val);
    }

    public static void main(String[] args) {
        Integer nums1[]={1,2,3,4,5,6,7};
        TreeNode treeNode = TreeNodeUtil.createTreeNode(nums1);
        new _116().LRD(treeNode);
        System.out.println(_116.nums);
        Node node = new Node(0);
        new _116().connect(node);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
