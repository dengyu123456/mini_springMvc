package com.dy.leetcode._链表相关;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给你这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _25YES {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode sentryHead = new ListNode(0);
        sentryHead.next = head;
        ListNode le = sentryHead;
        ListNode ri = sentryHead;
        int count = 0;
        //k=2 1->2->3->4->5  le指向sentryHead re指向2 count=k=2时翻转 (le，ri] [1,2]
        //结束时应该le、ri指向翻转后的最后一个节点 翻转后的最后一个节点指向之前ri的下一个节点
        //翻转后的第一个节点的上一个应该是之前的le；
        while (ri != null) {
            if (count == k) {
                //记录当前ri的下一个
                ListNode riNext = ri.next;
                //截取(le,ri]
                ri.next = null;
                //反转(le,ri]
                ListNode tail = reversal(le);
                tail.next = riNext;
                le = tail;
                ri = tail;
                count = 0;
            }
            ri = ri.next;
            count++;
        }
        return sentryHead.next;
    }

    //链表反转head节点之后的节点  返回最后一个节点
    //0-1-2-3-4  0-4-3-2-1
    public ListNode reversal(ListNode head) {
        ListNode tail = head.next;
        if (head.next == null) {
            return head;
        }
        ListNode le = head;// 需要指向cur的节点   0
        ListNode cur = head.next;//当前需要反转的节点 1
        ListNode ri = cur.next;//记录之前的le的下一个节点 2
        boolean flag = true;
        while (ri != null) {
            //3
            ListNode riNext = ri.next;
//            ListNode oldLe = le;
            //反转
            //0指向2
            le.next = ri;
            //2指向1
            ri.next = cur;
            if (flag) {
                cur.next = null;
                flag = false;
            }
//            le = ri; //le不变
            cur = ri;//cur变为2
            ri = riNext;//3
        }
        return tail;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4,5};

       // ListNode listNode = ListNode.addAll(nums);
        new _25YES().reverseKGroup(null,3);
    }


}
