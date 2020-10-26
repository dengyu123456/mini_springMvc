package com.dy.leetcode._数组指针相关;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _76NO {
    int min;

//    public String minWindow(String s, String t) {
//        if (t.length() > s.length()) {
//            return "";
//        }
//        char[] chars = t.toCharArray();
//        Map<Character, Integer> map1 = new HashMap<>();
//        Map<Character, Integer> map2 = new HashMap<>();
//        Map<Integer, String> map3 = new HashMap<>();
//        for (int i = 0; i < t.length(); i++) {
//            if (map1.containsKey(chars[i])) {
//                map1.put(chars[i], map1.get(chars[i]) + 1);
//                map2.put(chars[i], map2.get(chars[i]) + 1);
//            } else {
//                map1.put(chars[i], 1);
//                map2.put(chars[i], 1);
//            }
//        }
//        boolean flag = true;
//        boolean flag2 = true;
//        char[] sArr = s.toCharArray();
//        int le = 0, ri = 0; //[le,ri] 之间的就是满足存在t的子串 长度：ri-le+1
//        while (ri < s.length()) {
//
//            if (map2.containsKey(sArr[ri])) {
//                map2.put(sArr[ri], map2.get(sArr[ri]) + 1);
//            }
//            ri++;
//            flag = true;
//            flag2 = true;
//            //ri-le+1大于t的长度时，开始检查map当中的value是否是之前的2倍，如果是则记录ri和le对应的字串，进行下一轮循环
//            //if (ri - le + 1 > t.length()) {
//            //检查map当中value是否是之前的二倍  出现第一个是之前二倍le++；
//            for (Character key : map1.keySet()) {
//                if (!((map1.get(key) * 2) == map2.get(key))) {
//                    flag = false;
//                }
//                if (!(map1.get(key) == map2.get(key))) {
//                    flag2 = false;
//                }
//            }
//            if (flag2) {
//                le++;
//            }
//            //如果map1==map2 le++；
//            //当满足所有条件时，也就是找到一个满足条件的字串时记录第一个满足条件的字串
//            if (flag) {
//                map3.put(ri - le, s.substring(le, ri));
//                //ODEBANC
//                le = ri;
//                //将map2改为原来的样子
//                //特殊边界处理，如果ri指向的是属于满足条件的子串
//                for (Character key : map1.keySet()) {
//                    map2.put(key, map1.get(key));
//                }
//            }
//        }
//        return map3.isEmpty() ? "" : map3.get(getMinKey(map3));
//    }
public String minWindow(String s, String t) {
    if (t.length() > s.length()) {
        return "";
    }
    char[] chars = t.toCharArray();
    Map<Character, Integer> map1 = new HashMap<>();
    Map<Character, Integer> map2 = new HashMap<>();
    Map<Integer, String> map3 = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
        if (map1.containsKey(chars[i])) {
            map1.put(chars[i], map1.get(chars[i]) + 1);
            map2.put(chars[i], map2.get(chars[i]) + 1);
        } else {
            map1.put(chars[i], 1);
            map2.put(chars[i], 1);
        }
    }
    boolean flag = true;
    boolean flag2 = true;
    char[] sArr = s.toCharArray();
    int le = 0, ri = 0; //[le,ri] 之间的就是满足存在t的子串 长度：ri-le+1
    while (ri < s.length()) {

        if (map2.containsKey(sArr[ri])) {
            map2.put(sArr[ri], map2.get(sArr[ri]) + 1);
        }
        ri++;
        flag = true;
        flag2 = true;
        //ri-le+1大于t的长度时，开始检查map当中的value是否是之前的2倍，如果是则记录ri和le对应的字串，进行下一轮循环
        //if (ri - le + 1 > t.length()) {
        //检查map当中value是否是之前的二倍  出现第一个是之前二倍le++；
        for (Character key : map1.keySet()) {
            if (!((map1.get(key) * 2) == map2.get(key))) {
                flag = false;
            }
            if (!(map1.get(key) == map2.get(key))) {
                flag2 = false;
            }
        }
        if (flag2) {
            le++;
        }
        //如果map1==map2 le++；
        //当满足所有条件时，也就是找到一个满足条件的字串时记录第一个满足条件的字串
        if (flag) {
            map3.put(ri - le, s.substring(le, ri));
            //ODEBANC
            le = ri;
            //将map2改为原来的样子
            //特殊边界处理，如果ri指向的是属于满足条件的子串
            for (Character key : map1.keySet()) {
                map2.put(key, map1.get(key));
            }
        }
    }
    return map3.isEmpty() ? "" : map3.get(getMinKey(map3));
}


    public static Object getMinKey(Map<Integer, String> map) {
        if (map == null) return null;
        Set<Integer> set = map.keySet();
        Object[] obj = set.toArray();
        Arrays.sort(obj);
        return obj[0];
    }

    //大于返回true，小于返回false
    public boolean min(int i) {
        if (i != 0 && i < min) {
            min = i;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //"bdab"
        //"ab"
//        String s = "ADOBECODEBANC";
//        String t = "ABC";
        String s = "bdab";
        String t = "ab";
        System.out.println(new _76NO().minWindow(s, t));
        System.out.println(s.substring(1, 1));
    }
}
