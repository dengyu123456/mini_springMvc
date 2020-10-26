package com.dy.leetcode._链表相关;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _19NO {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentryHead = new ListNode(Integer.MIN_VALUE);
        sentryHead.next = head;
        int count = 0;
        ListNode temp = sentryHead;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        ListNode le = sentryHead;
        ListNode cur = head;
        ListNode ri = cur.next;
        int i = count - n-1;
        while (cur!= null) {
            if (i == 0) {
                //删除
                le.next = ri;
                cur.next = null;
                break;
            } else {
                le = cur;
                cur = ri;
                ri = ri.next;
            }
            i--;

        }
        return sentryHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode listNode = ListNode.addAll(nums);
        new _19NO().removeNthFromEnd(listNode, 2);
    }
}
