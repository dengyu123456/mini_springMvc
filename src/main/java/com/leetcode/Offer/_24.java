package com.leetcode.Offer;

public class _24 {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
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
        return le.next;
    }
}
