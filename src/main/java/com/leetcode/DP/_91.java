package com.leetcode.DP;


import java.util.*;

public class _91 {
    Map<String, Integer> baseMap = new HashMap<>();
    Set<String> visiSet = new HashSet<>();

    public int numDecodings(String s) {
        for (int i = 1; i <= 26; i++) {
            Integer i1 = i + 64;
            baseMap.put(i + "", i1);
        }
        dp(s, 0, "");
        return visiSet.size();
    }

    //暴力穷举所有可能
    public void dp(String s, int index, String preStr) {
        int endIndex = index;
        //取一个
        for (int j = 1; j <= s.length(); j++) {
            int beginIndex = index;
            String s1 = preStr;
            for (int i = index + j; i <= s.length(); i = j + i) {
                endIndex = i;
                String substring = s.substring(beginIndex, endIndex);
                s1 = s1 + "," + substring;
                if (!baseMap.containsKey(substring)) break;
                if (endIndex == s.length() && !visiSet.contains(s1)) {
                    visiSet.add(s1);
                }
                dp(s, i, s1);
                beginIndex = i;
            }
        }
    }

    public static void main(String[] args) {
        _91 a = new _91();
        System.out.println(a.numDecodings("2222"));
    }
}
