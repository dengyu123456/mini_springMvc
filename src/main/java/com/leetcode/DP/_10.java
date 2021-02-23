package com.leetcode.DP;

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
    public boolean isMatch(String s, String p) {
        if ("".equals(s) && "".equals(p)) return true;
        if ("".equals(s)) return false;
        //如果只有“。*”
        if (".*".equals(p)) return true;

        char[] strArray = s.toCharArray();
        char[] pArray = p.toCharArray();
        int j = 0;
        int i = 0;
        for (; i < pArray.length; ) {
            ////如果j扫描完了
            if (j == strArray.length && i < pArray.length) return false;
            if (j < strArray.length && strArray[j] == pArray[i]) {
                j++;
                i++;
            }
            //如果遇到 "."
            while (i < pArray.length && '.' == pArray[i]) {
                j++;
                i++;
            }
            //如果遇到“*”
            if (i < pArray.length && '*' == pArray[i]) {
                //代替0个
                
                //*代替一个a
                char preStr = pArray[i - 1];
                while (j < strArray.length && strArray[j] == preStr) {
                    j++;
                    if (isMatch(s.substring(j, s.length()), p.substring(i + 1, p.length()))) return true;
                }
                i++;
            }
            if (j < strArray.length&&i < pArray.length&&pArray[i] != strArray[j]) return false;
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
//        String p = "aaa*a";
        String s = "mississippi";
        String p = "mis*is*ip*.";
        System.out.println(new _10().isMatch(s, p));
    }
}
