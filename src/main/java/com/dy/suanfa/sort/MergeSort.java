package com.dy.suanfa.sort;

//归并排序
public class MergeSort {
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];

        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int r) {
        if (r <= lo) return;
        int mid = lo + (r - lo) / 2;
        //[l,mid]  [mid+1,r]
        sort(a, lo, mid);
        sort(a, mid + 1, r);
        merge(a, lo, mid, r);
    }

    public static void merge(Comparable[] a, int lo, int mid, int r) {
        //维护两个下标进行归并
        int i = lo;
        int j = mid + 1;
        //[l,mid]  [mid+1,r] 复制[l,r]到aux
        for (int k = lo; k <= r; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= r; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > r) {
                a[k] = aux[i++];
            } else if (less(aux[j], (aux[i]))) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
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
        Integer[] arr = {4, 3, 2, 1,1};
        sort(arr);
        show(arr);


    }
}
