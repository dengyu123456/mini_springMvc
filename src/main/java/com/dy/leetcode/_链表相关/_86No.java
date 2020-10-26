package com.dy.leetcode._链表相关;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 示例:
 * <p>
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class _86No {
    //思路，找到第一个应该放在左边的节点，
    // 比如不满足条件的第一个是2，2和上一个节点交换位置，再和4交换
    public ListNode partition(ListNode head, int x) {
        ListNode sentryHead = new ListNode(Integer.MIN_VALUE);
        sentryHead.next = head;
        ListNode le = null; //当前满足条件最右边的小于x的节点 比如：1
        ListNode ri = sentryHead; //当前不满足条件的第一个节点：2
        //交换过程：
        //将le.next指向ri (1指向2) 2指向之前的le.next(2指向4) 2就是当前的le
        //将temp指向之前的ri的下一个 3指向5   ri初始化为当前的le 2
        int count = 0; //le 到ri之间的节点数
        while (ri != null) {
            if (ri.val < x&&count==0) {
                //le=1
                le = ri;
            } else {
                count++;
            }
            //进入这里时 le=1  ri=2
            if (count > 0 && ri.val < x) {
                ListNode temp = null;
                ListNode temp1=le;
                while (count > 1) {
                    temp = temp1.next;
                    temp1=temp1.next;
                    count--;
                }
                count=0;
                //temp=3 3指向5
                if (temp==null){
                    return sentryHead.next;
                }
                temp.next = ri.next;
                //保存之前的le的下一个指向 保存4（tempLeNext）
                ListNode tempLeNext = le.next;
                //1指向2
                le.next = ri;
                //2指向4
                ri.next = tempLeNext;
                le = ri;
            }

            ri = ri.next;
        }
        return sentryHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2, 5, 2};
//        int[] nums = {1,1};
//        int[] nums = {2,1};
        ListNode listNode = ListNode.addAll(nums);
        new _86No().partition(listNode, 3);
    }

//    public static class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode(int x) {
//            val = x;
//        }
//
//        void add(ListNode node) {
//            this.next = node;
//
//        }
//
//        static ListNode addAll(int[] nums) {
//            ListNode head = new ListNode(-1);
//            ListNode listNode = new ListNode(nums[0]);
//            head.next = listNode;
//            for (int i = 1; i < nums.length; i++) {
//                listNode.next = new ListNode(nums[i]);
//                listNode = listNode.next;
//            }
//            return head.next;
//        }
//    }

}
