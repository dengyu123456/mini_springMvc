package com.leetcode.DP;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by D on 2021/4/28.
 */
public class _368 {
    //存储所有满足可能的结果集
    List<List<Integer>> ableList = new LinkedList<>();

    //暴力解
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        dp(nums, 0);
        int maxSize = Integer.MIN_VALUE;
        for (List<Integer> list : ableList) {
            if (list.size() > maxSize) {
                res = list;
                maxSize = list.size();
            }
        }
        return res;
    }

    public void dp(int nums[], int index) {
        for (int i = index; i < nums.length; i++) {
            List<List<Integer>> ableList2 = new LinkedList<>();
            if (ableList.size() == 0) {
                List<Integer> list = new LinkedList<>();
                list.add(nums[i]);
                ableList.add(list);
                continue;
            }

            for (int n = 0; n < ableList.size(); n++) {
                List<Integer> list = ableList.get(n);
                boolean falg = true;
                for (int j = 0; j < list.size() && falg; j++) {
                    if (list.get(j) % nums[i] != 0 && nums[i] % list.get(j) != 0) {
                        falg = false;

                        //把前面几个和这个数放在一个新list里面
                        List<Integer> integerList = new LinkedList<>();
                        for (int k = 0; k < j; k++) {
                            integerList.add(list.get(k));
                        }
                        integerList.add(nums[i]);
                        ableList2.add(integerList);
                    }
                }
                if (falg) {
                    list.add(nums[i]);
                }
            }
            ableList.addAll(ableList2);
        }

    }

    public static void main(String[] args) {
        //[5,9,18,54,108,540,90,180,360,720]
        int nums[] = {5, 9, 18, 54, 108, 540, 90, 180, 360, 720};
        new _368().largestDivisibleSubset(nums);
        System.out.println(540 % 65);
    }
}
