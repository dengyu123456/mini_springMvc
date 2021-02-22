package com.leetcode.DP;

public class _5 {
    //双指针穷举所有情况
    public String longestPalindrome(String s) {
        if ("".equals(s)) return "";
        char[] chars = s.toCharArray();
        String res = s.substring(0, 1);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < chars.length; i++) {
            int le = i - 1;
            int ri = i + 1;
            while (le >= 0 && chars[le] == chars[i]) {
                if (i - le > max) {
                    max = i - le;
                    res = s.substring(le, i + 1);
                }
                le--;
            }
            while (ri < chars.length && chars[ri] == chars[i]) {
                if (ri - i > max) {
                    max = ri - i;
                    res = s.substring(i, ri + 1);
                }
                ri++;
            }
            while (le >= 0 && ri < chars.length && chars[le] == chars[ri]) {
                if (ri - le > max) {
                    max = ri - le;
                    res = s.substring(le, ri + 1);
                }
                le--;
                ri++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "asadsaa";
        //System.out.println(s.substring(0, 3));
        System.out.println(new _5().longestPalindrome(s));
    }
}
