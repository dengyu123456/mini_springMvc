package com.leetcode.DP;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by D on 2021/4/28.
 */
public class _368 {
//    //存储所有满足可能的结果集
////    List<List<Integer>> ableList = new LinkedList<>();
////
////    //暴力解
////    public List<Integer> largestDivisibleSubset(int[] nums) {
////        List<Integer> res = new ArrayList<>();
////        dp(nums, 0);
////        int maxSize = Integer.MIN_VALUE;
////        for (List<Integer> list : ableList) {
////            if (list.size() > maxSize) {
////                res = list;
////                maxSize = list.size();
////            }
////        }
////        return res;
////    }
////
////    public void dp(int nums[], int index) {
////        for (int i = index; i < nums.length; i++) {
////            List<List<Integer>> ableList2 = new LinkedList<>();
////            if (ableList.size() == 0) {
////                List<Integer> list = new LinkedList<>();
////                list.add(nums[i]);
////                ableList.add(list);
////                continue;
////            }
////
////            for (int n = 0; n < ableList.size(); n++) {
////                List<Integer> list = ableList.get(n);
////                boolean falg = true;
////                for (int j = 0; j < list.size() && falg; j++) {
////                    if (list.get(j) % nums[i] != 0 && nums[i] % list.get(j) != 0) {
////                        falg = false;
////
////                        //把前面几个和这个数放在一个新list里面
////                        List<Integer> integerList = new LinkedList<>();
////                        for (int k = 0; k < j; k++) {
////                            integerList.add(list.get(k));
////                        }
////                        integerList.add(nums[i]);
////                        ableList2.add(integerList);
////                    }
////                }
////                if (falg) {
////                    list.add(nums[i]);
////                }
////            }
////            ableList.addAll(ableList2);
////        }
////
////    }


    //动态规划解
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> resList = new LinkedList<>();
        //Arrays.sort(nums);
        //dp[i]记录已 nums[i]结尾的元素满足answer[i] % answer[j] == 0 已第i个数结尾的最长数
        int dp[] = new int[nums.length + 1];
        //g[]记录dp[i]的前一个状态
        int g[] = new int[nums.length + 1];

//        //初始化
//        for (int i = 0; i < dp.length; i++) {
//            //所有元素都最少包含一个他本身
//            dp[i] = 1;
//        }
        for (int i = 0; i < g.length; i++) {
            //所有元素都最少包含一个他本身
            g[i] = -1;
        }
        int resMax = 0;
        int resIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    // dp[i] = Math.max(dp[j] + 1, dp[i]);
                    if ((dp[j] + 1) > dp[i]) {
                        dp[i] = dp[j] + 1;
                        g[i] = j;
                    }
                    if (dp[i] > resMax) {
                        resMax = dp[i];
                        resIndex = i;
                    }
                }
            }
        }
        while (resIndex != -1) {
            ((LinkedList<Integer>) resList).addFirst(nums[resIndex]);
            resIndex = g[resIndex];
        }
        //找到最大的
        return resList;
    }

    public static void main(String[] args) {
        //[5,9,18,54,108,540,90,180,360,720]
        int nums[] = {5, 9, 18, 54, 108, 540, 90, 180, 360, 720};
//        int nums[] = {1, 2,4,8};
        new _368().largestDivisibleSubset(nums);
    }
}
