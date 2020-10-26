package com.dy.leetcode._数组指针相关;

/**
 *
 */
public class _11NO {
    int max = 0;
    public int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;
        while (i!=j) {
            boolean left = false;
            if (height[i] < height[j]) left = true;
            int area = (left ? height[i] : height[j]) * (j - i);
            max = max > area ? max : area;
            if (left) i ++; else j --;
        }
        return max;
    }
//    //O(nlogN)级别
//    public int maxArea(int[] height) {
//        //[le，ri]之间的容积最大 目的就是一直维护这定义
//        int le = 0, ri = height.length - 1;
//        //什么时候调整指针？
//        int i, j;
//        m(height, le, ri);
//        boolean flagL=true;
//        boolean flagR=true;
//        // j必须大于i 当对撞时退出
//        while (le < ri) {
//            flagL=true;
//            flagR=true;
//            for (i = le; i < ri; i++) {
//                if (min(m(height, i, ri))) {
//                    le = i;
//                    flagL=false;
//                }
//            }
//            //如果一轮循环下来没有大于max的
//            if (flagL) {
//                ++le;
//            }
//            for (j = ri; j > le; j--) {
//                if (min(m(height, le, j))) {
//                    ri=j;
//                    flagR=false;
//                }
//            }
//            if (flagR){
//                --ri;
//            }
//        }
//        return min;
//    }

//    //暴力解法O（N^2）
//    public  int maxArea(int[] height) {
//        for (int i = 0; i < height.length; i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                int temp = m(height, i, j);
//                min(temp);
//            }
//        }
//        return min;
//    }

    //计算两个指针的容积是多少
    public int m(int[] nums, int i, int j) {
        //height
        int height = 0;
        if (nums[i] < nums[j]) {
            height = nums[i];
        } else {
            height = nums[j];
        }
        return (j - i) * height;
    }

    //大于返回true，小于返回false
    public boolean max(int i) {
        if (i > max) {
            max = i;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        int []arr={10,9,8,7,6,5,4,3,2,1};
        int []arr={2,0,0,0,0,0,0,0,0,2,1,3};
//        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        _11NO t11=new _11NO();
        System.out.println(t11.maxArea(arr));
    }
}
