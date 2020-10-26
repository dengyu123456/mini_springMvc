package com.dy.leetcode._数组指针相关;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，
 * 使得 A[i] + B[j] + C[k] + D[l] = 0。
 * <p>
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 * <p>
 * 例如:
 * <p>
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * <p>
 * 输出:
 * 2
 * <p>
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _454NO {
//    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
//        int count = 0;
//        //A[i] + B[j] + C[k] + D[l] = 0。
//        //map存储A[i] + B[j]的值
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int l = 0; l < D.length; l++) {
//            if (map.containsKey(D[l])) {
//                map.put(D[l], map.get(D[l]) + 1);
//            } else {
//                map.put(D[l], 1);
//            }
//        }
//        int temp = 0;
//        for (int i = 0; i < A.length; i++) {
//            for (int j = 0; j < B.length; j++) {
//                for (int k = 0; k < C.length; k++) {
//                    temp = 0 - A[i] - B[j] - C[k];
////                    if (map.containsKey(temp) && map.get(temp) > 0) {
////                        count = count + map.get(temp);
////                        if (map.get(temp) - 1 == 0) {
////                            map.remove(temp);
////                        } else {
////                            map.put(temp, map.get(temp) - 1);
////                        }
////                    }
//
//                    if (map.containsKey(temp)) {
//                        count=map.get(temp)+count;
//                    }
//
//                }
//            }
//        }
//        return count;
//    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        //A[i] + B[j] + C[k] + D[l] = 0。
        //map存储A[i] + B[j]的值
        int sum=0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int l = 0; l < D.length; l++) {
            for (int k = 0; k < C.length; k++) {
                sum=D[l] + C[k];
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                } else {
                    map.put(sum, 1);
                }
            }
        }
        int temp = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                temp = 0 - A[i] - B[j];
//                    if (map.containsKey(temp) && map.get(temp) > 0) {
//                        count = count + map.get(temp);
//                        if (map.get(temp) - 1 == 0) {
//                            map.remove(temp);
//                        } else {
//                            map.put(temp, map.get(temp) - 1);
//                        }
//                    }

                if (map.containsKey(temp)) {
                    count = map.get(temp) + count;
                }

            }
        }

        return count;
    }

    public static void main(String[] args) {
        //[-1,-1]
        //[-1,1]
        //[-1,1]
        //[1,-1]


        //[0,1,-1]
        //[-1,1,0]
        //[0,0,1]
        //[-1,1,1]
        int[] A = {0, 1, -1};
        int[] B = {-1, 1, 0};
        int[] C = {0, 0, 1};
        int[] D = {-1, 1, 1};
        System.out.println(new _454NO().fourSumCount(A, B, C, D));
    }
}
