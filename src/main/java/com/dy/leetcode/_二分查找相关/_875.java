package com.dy.leetcode._二分查找相关;

import java.sql.SQLOutput;

public class _875 {
    public int minEatingSpeed(int[] piles, int H) {
        int max = Integer.MIN_VALUE;
        int min = 0;
        //记录最大最小值
        for (int num : piles) {
            max = Math.max(max, num);
            // min = Math.min(min, num);
        }
        int le = min;
        int ri = max;
        int mid;
        while (ri > le) {
            //mid越大H越小
            mid = le + (ri - le) / 2;
            //大于证明mid小了
            int h = EatingSpeed(piles, mid);
            if (mid == 1 && h < H) {
                return 1;
            }
            if (h > H) {
                le = mid + 1;
            } else {
                ri = mid;
            }
        }
        return le;
    }

    //计算速度k 需要多少小时
    public int EatingSpeed(int[] piles, int k) {
        int h = 0;
        for (int num : piles) {
            if (k == 0) {
                h = h + 1;
            } else {
                if (num % k != 0) {
                    h = num / k + 1 + h;
                } else {
                    h = h + num / k;
                }
            }
        }
        return h;
    }

    public static void main(String[] args) {
        //[312884470]
        //968709470
        int nums[] = {312884470};
        System.out.println(new _875().minEatingSpeed(nums, 968709470));
        //  System.out.println(1 % 0);
    }
}
