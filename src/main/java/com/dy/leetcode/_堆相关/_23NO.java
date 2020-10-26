package com.dy.leetcode._堆相关;

import com.dy.leetcode._链表相关.ListNode;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//还有一个归并的思路
public class _23NO {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        //统计出lists的大小
        boolean falg = true;
        int count = 0;
        for (int i = 0; i < lists.length; i++) {
            ListNode listNode = lists[i];
            while (listNode != null) {
                count++;
                listNode = listNode.next;
                falg = false;
            }
        }
        if (falg) {
            return null;
        }
        PriorityBlockingQueueDemo queue = new PriorityBlockingQueueDemo(count + 1);
        for (int i = 0; i < lists.length; i++) {
            ListNode listNode = lists[i];
            while (listNode != null) {
                queue.insert(listNode.val);
                listNode = listNode.next;
            }
        }
        ListNode head = new ListNode(-1);
        ListNode listNode = new ListNode(queue.pop());
        head.next = listNode;
        while (!queue.isEmpty()) {
            listNode.next = new ListNode(queue.pop());
            listNode = listNode.next;

        }
        return head.next;
    }

//    public static void main(String[] args) {
//        //[[1,4,5],[1,3,4],[2,6]]
//        int arr1[] = {1, 4, 5};
//        int arr2[] = {1, 3, 4};
//        int arr3[] = {2, 6};
//        ListNode listNode1 = ListNode.addAll(arr1);
//        ListNode listNode2 = ListNode.addAll(arr2);
//        ListNode listNode3 = ListNode.addAll(arr3);
//        ListNode[] listNodes = {listNode1,
//                listNode2,
//                listNode3};
//        new _23NO().mergeKLists(listNodes);
//    }
}

class PriorityBlockingQueueDemo {

    //初始化
    private Integer initialCapacity = 2;

    //队列数量
    int capacity;

    Integer[] data;

    //队列中的元素数量
    int count = 0;

    PriorityBlockingQueueDemo(int capacity) {
        if (capacity < initialCapacity) {
            data = new Integer[initialCapacity];
            this.capacity = initialCapacity;
        } else {
            this.capacity = capacity;
            data = new Integer[capacity];
        }
    }

    public void insert(Integer item) {
        if (count < capacity) {
            data[count] = item;
            shiftUp(count);
            count = count + 1;
        }
        //扩容
    }


    //最大堆的性质：父节点永远大于子节点
    private void shiftUp(int index) {
        //index是插入的节点 节点为0的，左孩子是奇数 右孩子是偶数
        //判断是左孩子还是右孩子
        int parentIndex;
        if (index == 0) {
            return;
        }
        if (index % 2 == 0) {
            parentIndex = ((index - 2) < 0 ? 0 : index - 2) / 2;
        } else {
            parentIndex = ((index - 1) < 0 ? 0 : index - 1) / 2;
        }
        if (data[index] > data[parentIndex]) {
            return;
        }
        swap(index, parentIndex);
        shiftUp(parentIndex);


    }

    public boolean isEmpty() {
        return count <= 0;
    }

    public int pop() {
        int result = this.data[0];
        data[0] = data[count - 1];
        count--;
        shiftDown(0);
        return result;
    }

    private void shiftDown(int index) {
        if (index >= count) {
            return;
        }
        //左孩子
        int leftChild = (index * 2 + 1) > count ? count : index * 2 + 1;
        //右孩子
        int rightChild = index * 2 + 2 > count ? count : index * 2 + 2;
        //如果孩子节点大于父子节点 则交换位置
        int maxChildIndex = data[rightChild] < data[leftChild] ? rightChild : leftChild;
        if (data[maxChildIndex] > data[index]) {
            return;
        }
        swap(maxChildIndex, index);
        shiftDown(maxChildIndex);
        if (maxChildIndex == count) {
            return;
        }
    }

    public void swap(int index1, int intdex2) {
        Integer temp = data[index1];
        data[index1] = data[intdex2];
        data[intdex2] = temp;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */