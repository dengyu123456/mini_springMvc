package com.leetcode.DP;

import jdk.nashorn.internal.ir.IfNode;

public class _10 {
    //    //暴力枚举，双指针
//    public boolean isMatch(String s, String p) {
//        if ("".equals(s) && "".equals(p)) return true;
//        if ("".equals(s)) return false;
//        //如果只有“。*”
//        if (".*".equals(p)) return true;
//
//        char[] strArray = s.toCharArray();
//        char[] pArray = p.toCharArray();
//        int j = 0;
//        int i = 0;
//        for (; i < pArray.length; ) {
//            ////如果j扫描完了
//            if (j==strArray.length&&i<pArray.length) return false;
//            if (j < strArray.length && strArray[j] == pArray[i]) {
//                j++;
//                i++;
//            }
//            //如果遇到 "."
//            while (i < pArray.length && '.' == pArray[i]) {
//                j++;
//                i++;
//            }
//            //如果遇到“*”
//            if (i < pArray.length && '*' == pArray[i]) {
//                char preStr = pArray[i - 1];
//                //如果前一个是 “.”  //就是 “.*” 的情况
//                if (preStr == '.') {
//                    //如果当前的是最后一个
//                    if (i == pArray.length - 1) {
//                        return true;
//                    } else {
//                        char after = pArray[i + 1];
//                        while (j < strArray.length && strArray[j] != after) {
//                            j++;
//                        }
//                        if (j >= strArray.length) {
//                            return false;
//                        }
//                    }
//                } else {
//                    while (j <strArray.length && strArray[j] == preStr) {
//                        //*代替一个a
//                        if (isMatch(s.substring(j, s.length()), p.substring(i + 1, p.length()))) return true;
//                        j++;
//                    }
//                    if (j==strArray.length&&strArray[j-1]==preStr)
//                }
//                i++;
//            }
////            if (pArray[i]!=strArray[j]) return false;
//        }
//
//        if (j < strArray.length) return false;
//        return true;
//    }
//暴力枚举，双指针
//    public boolean isMatch(String s, String p) {
//        if ("".equals(s) && "".equals(p)) return true;
//        if ("".equals(s)) return false;
//        //如果只有“。*”
//        if (".*".equals(p)) return true;
//
//        char[] strArray = s.toCharArray();
//        char[] pArray = p.toCharArray();
//        int j = 0;
//        int i = 0;
//        for (; i < pArray.length; ) {
//            if (j < strArray.length && strArray[j] == pArray[i]) {
//                j++;
//                i++;
//            }
//            //如果遇到 "."
//            while (i < pArray.length && '.' == pArray[i]) {
//                j++;
//                i++;
//            }
//            //如果遇到“*”
////            if (j == strArray.length && ((i < pArray.length && pArray[i] == '*')||(i+1<pArray.length&&pArray[i+1]=='*'))) {
//            if (j == strArray.length && ((i < pArray.length && pArray[i] == '*'))) {
//                //去掉i-1和i
//                int k = 1;
//                while (j - k >= 0) {
//                    if (isMatch(s.substring(j - k, strArray.length), p.substring(i + k, p.length()))) return true;
//                    if (i-1>=0&&isMatch(s.substring(j - k, strArray.length), p.substring(i -1, p.length()))) i++;
//                    k++;
//                }
//            }
//            //如果最后一个是*
//            if (i < pArray.length && j < strArray.length && strArray[j] != pArray[i]) {
//                if (pArray[i] == '*') {
//                    if (i - 1 < 0) return false;
//                    char preStr = pArray[i - 1];
//                    //*代替一个以上
//                    while (j < strArray.length && strArray[j] == preStr) {
//                        if (isMatch(s.substring(j, s.length()), p.substring(i + 1, p.length()))) return true;
//                        j++;
//                    }
//                    i++;
//                } else if (i + 1 < pArray.length && pArray[++i] == '*') {
//                    char preStr = pArray[i];
//                    //*代替一个以上
//                    while (j < strArray.length && strArray[j] == preStr) {
//                        if (isMatch(s.substring(j, s.length()), p.substring(i, p.length()))) return true;
//                        j++;
//                    }
//                    i++;
//                } else {
//                    return false;
//                }
//
//            }
//            if (j == strArray.length && i < pArray.length) return false;
//            // if (j < strArray.length&&i < pArray.length&&pArray[i] != strArray[j]) return false;
//            ////如果j扫描完了
//
//        }
//
//        if (j < strArray.length) return false;
//
//        return true;
//    }

    public boolean isMatch(String s, String p) {
        if ("".equals(s) && "".equals(p)) return true;
        //如果只有“。*”
        if (".*".equals(p)) return true;

        char[] strArray = s.toCharArray();
        char[] pArray = p.toCharArray();
        int j = 0;
        int i = 0;
        for (; i < pArray.length; ) {
            while (j < strArray.length && i < pArray.length && strArray[j] == pArray[i]) {
                j++;
                i++;
            }
            //如果遇到 "."
            while (i < pArray.length && '.' == pArray[i]) {
                j++;
                i++;
            }

            //如果遇到*
            int k = i;
            if (k < pArray.length && pArray[k] != '*') {
                k++;
            }
            //k就是遇到的*
            //第一种情况代表0个
            if (k < pArray.length && pArray[k] == '*') {
                if (j-1>=0&&isMatch(s.substring(j-1, s.length()), p.substring(k + 1, p.length()))) return true;
                //第二种情况代替1个以上 k-1；
                while (j < strArray.length && (pArray[k - 1] == strArray[j] || pArray[k - 1] == '.')) {
                    if (isMatch(s.substring(j, s.length()), p.substring(k + 1, p.length()))) return true;
                    j++;
                }
                i = k + 1;
            }
            //如果到这里已经扫描完了
            if (j == strArray.length - 1 && i == pArray.length - 1 && strArray[j] == pArray[i]) return true;
            if (j == strArray.length && i < pArray.length && pArray[i] != '*') return false;

            if (j < strArray.length && i < pArray.length && pArray[i] != strArray[j] && pArray[i] != '.') return false;
            if (i != k + 1) {
                i++;
            }
        }

        if (j < strArray.length) return false;

        return true;
    }

    public static void main(String[] args) {
        //"abbba"
        //"a..*w"

        //"aab"
        //"c*a*b"

        //"mississippi"
        //"mis*is*ip*."


        //"aaa"
        //"ab*ac*a"
//        String s = "aaa";
//        String p = "aaa*av";
//        String s = "mississippi";
//        String p = "mis*is*p*.";
        //"aba"
        //"a.*aa"
        //"ab"
        //".*c"
//        String s = "ab";
//        String p = ".*c";
        //"a"
        //"ab*a"
        String s = "a";
        String p = "ab*a";
        System.out.println(new _10().isMatch(s, p));
//        System.out.println(s.substring(1, 1));
    }
}
