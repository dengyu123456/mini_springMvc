package com.dy.threadDemo.test;

public class main2 {


    public static void main(String[] args) {
        String a = "356406010024817";
        System.out.println(a + "  " + m(a));
    }

    public static String m(String a) {
        int s = 0;
        int ss = 0;
        for (int i = a.length(); i >= 1; i--) {
            //偶数
            if (i % 2 == 0) {
                String c = a.charAt(i - 1) + "";
                int temp = Integer.parseInt(c) * 2;
                if (temp > 9) {
                    ss = ss + temp - 9;
                } else {
                    ss = ss + temp;
                }
            }
            //奇数
            if (i % 2 != 0) {
                String b = a.charAt(i - 1) + "";
                s = s + Integer.parseInt(b);
            }
        }
        //奇数和偶数求和
        if ((s+ss) % 10 == 0) {
            return "ok";
        } else {
            return "error";
        }
    }
}
