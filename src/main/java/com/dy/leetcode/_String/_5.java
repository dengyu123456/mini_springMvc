package com.dy.leetcode._String;

import java.util.ArrayList;
import java.util.List;

public class _5 {
    public String longestPalindrome(String s) {
        List<String> resList = new ArrayList<String>();
        char[] chars = s.toCharArray();
        char[] copyS = new char[chars.length];
        for (int i = chars.length - 1; i >= 0; i--) {
            copyS[i] = chars[chars.length - i - 1];
        }
        String res = "";
        
        int maxLeth = 0;
        for (String s1 : resList) {
            if (s1.length() > maxLeth) {
                maxLeth = s1.length();
                res = s1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _5().longestPalindrome(
                "aacaaa"));
                  //aaacaa
    }
}
