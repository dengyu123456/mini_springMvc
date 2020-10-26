package com.dy.leetcode._链表相关;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    void add(ListNode node) {
        this.next = node;

    }

   public static ListNode addAll(int[] nums) {
        ListNode head = new ListNode(-1);
        ListNode listNode = new ListNode(nums[0]);
        head.next = listNode;
        for (int i = 1; i < nums.length; i++) {
            listNode.next = new ListNode(nums[i]);
            listNode = listNode.next;
        }
        return head.next;
    }

}
