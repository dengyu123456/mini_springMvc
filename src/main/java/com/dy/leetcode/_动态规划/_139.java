package com.dy.leetcode._动态规划;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _139 {
    Map<String, Boolean> map = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        map.put("", true);
        boolean word = word(s, wordDict);
        return word;
    }

    public boolean word(String s, List<String> wordDict) {
        if (s == "" || s.length() == 0) {
            return true;
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }
        for (String str : wordDict) {
            int i = s.indexOf(str);
            if (i < 0) {
                continue;
            }
            String s1 = s.substring(0, i);
            String s2 = s.substring(i + str.length(), s.length());
            boolean s1Falg = word(s1, wordDict);
            boolean s2Falg = word(s2, wordDict);
            map.put(s1, s1Falg);
            map.put(s2, s2Falg);
            if (s1Falg && s2Falg) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        String s = "applepenapple";
//        List<String> list = new ArrayList<>();
//        list.add("apple");
//        list.add("pen");

        String s = "catsandog";
        List<String> list = new ArrayList<>();
        list.add("cats");
        list.add("dog");
        list.add("sand");
        list.add("and");
        list.add("cat");
//"cars"
//["car","ca","rs"]
//        String s = "cars";
//        List<String> list = new ArrayList<>();
//        list.add("car");
//        list.add("ca");
//        list.add("rs");
        new _139().wordBreak(s, list);
    }
}
