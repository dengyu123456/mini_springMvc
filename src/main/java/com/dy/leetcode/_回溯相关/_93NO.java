package com.dy.leetcode._回溯相关;

import java.util.ArrayList;
import java.util.List;

//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
//
//有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
//
//例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
//
// 
//
//示例 1：
//
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
//示例 2：
//
//输入：s = "0000"
//输出：["0.0.0.0"]
//示例 3：
//
//输入：s = "1111"
//输出：["1.1.1.1"]
//示例 4：
//
//输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
//示例 5：
//
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/restore-ip-addresses
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _93NO {
    List<List<String>> resList = new ArrayList<>();
    List<String> pathList = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {

        char[] a = s.toCharArray();
        List<String> res = new ArrayList<>();
        if (s.length()>12){
            return res;
        }
        restoreIpAddresses(a, 0, 0);
        for (List<String> list : resList) {
            String resStr = "";
            for (int i = 0; i < list.size(); i++) {
                if (i == list.size() - 1) {
                    resStr = resStr + list.get(i);
                } else {
                    resStr = resStr + list.get(i) + ".";
                }
            }
            res.add(resStr);
        }
        return res;
    }

    public void restoreIpAddresses(char a[], int index, int lv) {

        String s = "";
        if (lv > 4) {
            return;
        }
        if (index == a.length && lv == 4) {
            List<String> list = new ArrayList<>();
            list.addAll(pathList);
            resList.add(list);
        }
        for (; index < index + 3 && index < a.length; index++) {
            s = s + a[index];
            //[0,255]
            if (s.length() >= 2 && s.indexOf("0") == 0) {
                continue;
            }
            if (Long.parseLong(s) >= 0 && Long.parseLong(s) <= 255) {
                pathList.add(s + "");
                restoreIpAddresses(a, index + 1, lv + 1);
                pathList.remove(pathList.size() - 1);
            } else {
                continue;
            }
        }
        return;
    }

    public static void main(String[] args) {
        String s = "0000";
        new _93NO().restoreIpAddresses(s);
    }
}
