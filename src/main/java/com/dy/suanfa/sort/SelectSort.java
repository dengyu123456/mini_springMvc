package com.dy.suanfa.sort;

import java.util.HashMap;
import java.util.Map;

//选择排序
public class SelectSort {
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            //每次选择一个最小的值放在i的位置
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换元素
     *
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) { //在单行中打印数组
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    /**
     * 判断数组是否有序
     *
     * @param a
     * @return
     */
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // 从标准输入读取字符串，将它们排序并输出
        Integer[] arr = {12, 524, 13221, 5, 4, 5, 32, 34, 5, 512, 3, 3, 765, 7, 876, 54};
        sort(arr);
        show(arr);
        HashMap<Object, Object> map = new HashMap<>();

    }
}
