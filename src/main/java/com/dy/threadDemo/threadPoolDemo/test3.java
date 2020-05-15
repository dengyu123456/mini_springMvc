package com.dy.threadDemo.threadPoolDemo;

import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ab = in.next().trim();
        String[] split = ab.split(",");
        if ("".equals(ab) || split.length == 0) {
            System.out.println("/");
        } else {
            String a = split[0];
            String b = split[1];
            String a1 = a.replace("/", "");
            String b1 = b.replace("/", "");
            System.out.println("/" + a1 + "/" + b1);
        }
    }
}
