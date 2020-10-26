package com.dy.leetcode._链表相关;

import java.math.BigDecimal;

/**
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _234 {
    public boolean isPalindrome(ListNode head) {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        int le=1;
        int ri=count;
        
        return true;
    }

    public static void main(String[] args) {
        int []nums={1,2,2,1};
        ListNode listNode = ListNode.addAll(nums);
        new _234().isPalindrome(listNode);


//        String fee = "0.2";
//        Long game_amount = 400000l;
//        Long loan_amount =2400000l;
//        BigDecimal rate = new BigDecimal(fee).add(new BigDecimal(1));
//        BigDecimal actualAmount = new BigDecimal(loan_amount).divide(rate);
//        System.out.println(actualAmount.subtract(new BigDecimal(game_amount)));
    }
}
