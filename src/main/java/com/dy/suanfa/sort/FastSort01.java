package com.dy.suanfa.sort;

public class  FastSort01  {
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    //[lo,r]
    public static void sort(Comparable[] a, int lo, int r) {
        if (r <= lo) return;
        int p = partition(a, lo, r);
        //[lo,p-1]   [p+1,r]  p已经处理了，不做处理
        sort(a, lo, p - 1);
        sort(a, p + 1, r);
    }

    //返回元素应该在的位置
    private static int partition(Comparable[] a, int lo, int r) {
        //找到下标为lo的元素应该在数组当中的位置
        //[lo+1,i) <=v <=(j,r]
        int i = lo + 1, j = r;
        Comparable v = a[lo];
        while (true) {
            //如果a[lo++]<
            while (i <= r && less(a[i], v)) {
                i++;
            }
            while (j >= lo + 1 && less(v, a[j])) {
                j--;
            }
            if (i >= j) break;
            exch(a, i, j);
            i++;
            j--;

        }
        exch(a, lo,j);
        return j;
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
        Integer[] arr = {4, 3, 2, 1,1,1,3,3,3,4,4,4};
        sort(arr);
        show(arr);

    }

}
