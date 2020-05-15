package com.dy.threadDemo.threadPoolDemo;

import com.dy.threadDemo.test.CountTask;
import com.sun.org.apache.xpath.internal.operations.Mod;

import java.util.Scanner;

public class test1 extends CountTask {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ab = in.nextLine();
        //非字母替换为空格
        String reg = "[^a-zA-Z]";
        ab=ab.replaceAll(reg," ");
        String[] s = ab.split(" ");
        //求出中间值
        int length = s.length;
        int m = 0;
        if (length % 2 == 0) {
            m = length / 2;
        } else {
            m = length / 2 + 1;
        }
        for (int i = 0; i < m; i++) {
            //交换位置
            String temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp.trim();
        }
        String result = "";
        for (int i = 0; i < s.length; i++) {
            if (i != s.length - 1) {
                result = result + s[i] + " ";
            } else {
                if ("".equals(s[i])){
                    continue;
                }else {
                    result = result + s[i];
                }
            }
        }
        System.out.println(result.trim());
    }

}
