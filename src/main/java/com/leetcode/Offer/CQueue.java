package com.leetcode.Offer;

import java.util.Stack;

public class CQueue {
    private Stack<Integer> stackA = null;
    private Stack<Integer> stackB = null;

    public CQueue() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }

    public void appendTail(int value) {
        stackA.push(value);
    }

    public int deleteHead() {
        if (stackB.isEmpty() && stackA.isEmpty()) return -1;
        int res = -1;
        if (stackB.isEmpty()) {
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
            res = stackB.pop();
        } else {
            res = stackB.pop();
        }
        return res;
    }
}
