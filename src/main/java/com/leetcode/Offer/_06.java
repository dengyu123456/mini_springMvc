package com.leetcode.Offer;

public class _06 {
    //翻转链表
    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[0];
        ListNode le = new ListNode(-1);
        ListNode p = head;
        ListNode ri = head.next;
        head.next = null;
        le.next = head;
        int count = 1;
        while (ri != null) {
            le.next = ri;
            ListNode temp = ri.next;
            ri.next = p;
            p = ri;
            ri = temp;
            count++;
        }
        int[] nums = new int[count];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = le.next.val;
            le = le.next;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ListNode listNode = arrayToListNode(nums);
        new _06().reversePrint(listNode);
    }

    public static ListNode arrayToListNode(int[] s) {
        ListNode root = new ListNode(s[0]);
        ListNode other = root;
        for (int i = 1; i < s.length; i++) {
            ListNode temp = new ListNode(s[i]);
            other.next = temp;
            other = temp;
        }
        return root;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
