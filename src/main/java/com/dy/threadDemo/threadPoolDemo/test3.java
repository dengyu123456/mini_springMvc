package com.dy.threadDemo.threadPoolDemo;

import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
////        String ab = in.next().trim();
////        String[] split = ab.split(",");
////        if ("".equals(ab) || split.length == 0) {
////            System.out.println("/");
////        } else {
////            String a = split[0];
////            String b = split[1];
////            String a1 = a.replace("/", "");
////            String b1 = b.replace("/", "");
////            System.out.println("/" + a1 + "/" + b1);
////        }

//        String a="KantongDuitAAAAAAAAAA";
//        String b="KantongDuit, Selamat, Anda telah memperoleh batas kredit Rp 20000.00 Sekarang Anda dapat mengajukan pinjaman dengan masuk ke KantongDuit.";
//      b = b.replaceAll("KantongDuit", "StarBag");
//        System.out.println(b);
        int j = '耀';
        char i = '耀';
        System.out.println(j);//32768
        System.out.println((int) i);//32768
        boolean flag = true;
        A(flag?i:2);
        A(i);
    }

    public static void A(int i) {
        System.out.println("3目运算符测试" + i);
    }
}
