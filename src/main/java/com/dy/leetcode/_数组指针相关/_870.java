package com.dy.leetcode._数组指针相关;

import com.dy.minispringMvc.test.A;

import java.util.Arrays;

//870. 优势洗牌
//给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。
//
//返回 A 的任意排列，使其相对于 B 的优势最大化。
//
//
//
//示例 1：
//
//输入：A = [2,7,11,15], B = [1,10,4,11]
//输出：[2,11,7,15]
//示例 2：
//
//输入：A = [12,24,8,32], B = [13,25,32,11]
//输出：[24,32,8,12]
//
public class _870 {
    public static boolean[] visit = null;

    public int[] advantageCount(int[] A, int[] B) {
        int[] copyA = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            copyA[i] = -1;
        }
        Arrays.sort(A);
        visit = new boolean[A.length];
        for (int i = 0; i < B.length; i++) {
            //寻找一个刚好大于B[i] A中的最小值
            int minAThanB = findMinAThanB(A, B[i]);
            if (minAThanB != -1) {
                copyA[i] = A[minAThanB];
            }
        }
        for (int i = 0; i < visit.length; i++) {
//            if (copyA[i] == -1) {
//                copyA[i] = findMinA(A);
//            }
            if (copyA[i] == -1) {
                for (int j = 0; j < A.length && !visit[j]; j++) {
                    copyA[i] = A[j];
                    visit[j] = true;
                }
            }
        }
        return copyA;
    }
    //寻找一个刚好大于B[i] A中的最小值
    public int findMinAThanB(int[] A, int a) {
        int index = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > a && A[i] < min && !visit[i]) {
                index = i;
                min = A[i];
            }
        }
        if (index != -1) {
            visit[index] = true;
        }
        return index;
    }
    public int findMinA(int[] A) {
        int index = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (!visit[i]) {
                min = Math.min(min, A[i]);
                index = i;
            }
        }
        visit[index] = true;
        return A[index];
    }

    public static void main(String[] args) {
        //[2,7,11,15]
        //[1,10,4,11]

        //[5621,1743,5532,3549,9581]
        //[913,9787,4121,5039,1481]
        int[] A = {5621,1743,5532,3549,9581};
        int[] B = {913,9787,4121,5039,1481};
        new _870().advantageCount(A, B);
    }
}
