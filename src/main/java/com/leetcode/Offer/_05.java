package com.leetcode.Offer;

import java.util.Arrays;

public class _05 {
    public String replaceSpace(String s) {
//        //3ms  15%
        //return s.replaceAll(" ", "%20");
        //7ms 5%
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        System.out.println(new _05().replaceSpace("a a"));
        String s="aa";
        char []a={'b','b'};
        a= Arrays.copyOf(a,4);
        s.getChars(0,s.length(),a,2);

        System.out.println(s);
        System.out.println(a);
    }
}
