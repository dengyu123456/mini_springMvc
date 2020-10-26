package com.dy.threadDemo.test;

import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class Example {
//    public static void main(String[] args) {
//        Map<Integer, String> map = new HashMap<>();
//        List<String> list = new ArrayList<>();
//        for (int i = 1; i <= 9; i++) {
//            //去除重复值，比如（2，9） （9，2）这种组合
//            for (int j = i + 1; j <= 9; j++) {
//                int r = i * j;
//                //如果在map当中出现了值，说明其肯定
//                //存在另外的一对数满足它们的乘积相等，
//                // 则将i和j取出放入list集合记录结果
//                if (map.get(r) != null) {
//                    list.add(i + "," + j + "," + map.get(r));
//                } else
//                    map.put(r, i + "," + j);
//            }
//        }
//        for (String str : list) {
//            String[] split = str.split(",");
//            //输出02，13的组合
//            System.out.println(split[0]+split[2]+"*"+split[1]+split[3]);
//        }
//    }

//    public static void main(String[] args) {
//        int A[] = {10, 7, 5, 4};
//        //找出最大的值的下标
//int m=0;
//while (true){
//        for (int j = 0; j < 120; j++) {
//            int min = 0;
//            for (int i = 1; i < A.length; i++) {
//                if (A[min] < A[i]) {
//                    min = i;
//                }
//            }
//            for (int i = 0; i < A.length; i++) {
//                if (min == i) {
//                    A[min] = A[min] - 3;
//                }else {
//                    A[i]=A[i]+1;
//                }
//            }

//            //如果按照26个人均分到每个项目组为最优解的话，26/4=6.5  那么当它们
//            //有一个值等于8的时候都是不均分的
//            int count=0;
//            for (int i = 0; i < A.length; i++) {
//                if (A[i] >= 8) {
//                    A[i] = A[i] - 3;
//                    count++;
//                } else {
//                    A[i]=A[i]+1;
//                }
//            }
//            m++;
//            if (count==0){
//                break;
//            }
//        }
//        System.out.println(m+"次");
//        for (int i = 0; i < A.length; i++) {
//            System.out.println(A[i]);
//        }
    //   }

    /**
     * 1、2、5、10
     * 两个数n(游戏币的个数)，m(总⾯值)。
     *
     * @return
     */
    public static void main(String[] args) {

//        List<int[]> list = methohb(6, 20);
        List<int[]> list = methohb(6, 20);
        for (int[] a : list) {
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i] + "，");
            }
            System.out.println(" ");
        }
    }

    public static List<int[]> methohb(int n, int m) {
        List<int[]> rlist = new ArrayList<>();
        //定义取值数组
        int A[] = {1, 2, 5, 10};

        int j = 0;
        int[] newArr = new int[n];
        int count = 0;
        int k = 0;
        int o = 0;
        while (j < A.length) {
            for (int i = 0; i < newArr.length; i++) {

                //如果count已经大于了m
//                if (count > m && newArr[newArr.length - 1] != 0) {
//                    //必须减去之前的值求出来的值才是正确的
//                    count = count - newArr[i]+A[j-2];
//                    //将newArr在i处的值替换为j-k
//                    newArr[i] = A[j - 2];
                o = 0;
                k = j;
                while (count > m && newArr[newArr.length - 1] != 0 && o < newArr.length) {

                    while (k > 0) {
                        //必须减去之前的值求出来的值才是正确的
                        count = count - newArr[o] + A[j - k];
                        //将newArr在i处的值替换为j-k
                        newArr[o] = A[j - k];
                        //如果还是大于m，k的值不变
                        if (!(count > m)) {
                            k--;
                        } else {
                            //o的值加1
                            o++;
                        }
                        if (count == m) {
                            break;
                        }
                    }
                    //o++;
                }
//                k = 0;
//                o = 0;
                //必须减去之前的值求出来的值才是正确的
                if (count == m && newArr[newArr.length - 1] != 0) {
                    rlist.add(newArr);
                    //count变为0并且创建一个新数组
                    newArr = new int[n];
                    count = 0;
                    break;
                }
                count = count + A[j] - newArr[i];
                //将1加入到newArr数组
                newArr[i] = A[j];


            }
//            if (count>m){
//                k++;
//            }
            if (count < m) {
                j++;
            }
        }
        return rlist;
    }

    public boolean check(int n, int m) {
        //先确定最小和最大值
        if (m > n * 10 || m < n * 1) {
            return false;
        }
        return true;
    }
}

