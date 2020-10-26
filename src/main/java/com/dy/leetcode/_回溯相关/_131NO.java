package com.dy.leetcode._回溯相关;
//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
//
//返回 s 所有可能的分割方案。
//
//示例:
//
//输入: "aab"
//输出:
//[
//  ["aa","b"],
//  ["a","a","b"]
//]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/palindrome-partitioning
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import com.dy.minispringMvc.test.A;

import java.util.ArrayList;
import java.util.List;

public class _131NO {
    List<List<String>> res = new ArrayList<>();

    List<String> pathList = new ArrayList<>();

    public List<List<String>> partition(String s) {
        char[] chars = s.toCharArray();
        partition(chars, 0);
        return res;
    }

    public void partition(char[] chars, int index) {
        if (index == chars.length ) {
            List<String> list = new ArrayList<>();
            list.addAll(pathList);
            res.add(list);
        }
        String s = "";
        for (; index < chars.length; index++) {
            s = s + chars[index];
            //如果是回文序列则加入pathlist
            if (isPalindrome(s)) {
                pathList.add(s);
                partition(chars, index + 1);
                pathList.remove(pathList.size() - 1);
            }
        }
    }

    //判断是否是回文字符串
    private boolean isPalindrome(String str) {
        char[] chars = str.toCharArray();
        int le = 0;
        int ri = chars.length - 1;
        while (le < ri) {
            if (chars[le] != chars[ri]) {
                return false;
            }
            le++;
            ri--;
        }
        return true;
    }

    public static void main(String[] args) {
        new _131NO().partition("aab");
    }
}

