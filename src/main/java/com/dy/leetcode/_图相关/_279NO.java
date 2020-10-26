package com.dy.leetcode._图相关;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 * <p>
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 */
//思路：图论的思路来做的话也就是遍历n到0的最短路径的问题
//图的定义x、y之间如果相差一个完全平方数的话，那么x、y之间有一条线
public class _279NO {
    public int numSquares(int n) {
        ConcurrentLinkedQueue<List<Integer>> queue = new ConcurrentLinkedQueue<>();
        //记录已经访问过的元素
        Boolean[] visitNums = new Boolean[n + 1];
        List<Integer> firstList = new ArrayList<>(2);
        //list当中的两个值，0：具体的元素 1：该元素属于第几层；
        firstList.add(n);
        firstList.add(0);
        queue.add(firstList);
        while (!queue.isEmpty()) {
            List<Integer> poll = queue.poll();
            Integer nums = poll.get(0);
            Integer count = poll.get(1);
            for (int i = 1; ; i++) {
                int a = nums - i * i;
                if (a < 0) {
                    break;
                }
                if (a == 0) {
                    return count + 1;
                }
                //如果当前元素没有被访问过
                if (visitNums[a] == null || !visitNums[a]) {
                    ArrayList<Integer> integers = new ArrayList<>(2);
                    integers.add(a);
                    integers.add(count + 1);
                    queue.add(integers);
                    visitNums[a] = true;
                }

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new _279NO().numSquares(0));
    }
}
