package com.dy.leetcode._String;

//最长公共前缀
public class _14 {
    public String longestCommonPrefix(String[] strs) {
        String reStr = "";
        if (strs == null||strs.length==0) {
            return reStr;
        }

        int count = 1;
        char[] chars = strs[0].toCharArray();
        for (int i = 0; i < chars.length; i++) {
            count = 1;
            for (int j = 1; j < strs.length; j++) {
                if (i>strs[j].length()-1){
                    return reStr;
                }
                if (strs[j].substring(i, i + 1).equals(chars[i] + "")) {
                    count++;
                }else {
                    return reStr;
                }
            }
            if (count == strs.length) {
                reStr = reStr + chars[i];
            }
        }
        return reStr;
    }

    public static void main(String[] args) {

    }
}
