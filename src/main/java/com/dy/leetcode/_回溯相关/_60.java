package com.dy.leetcode._回溯相关;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by D on 2020/10/28.
 */
public class _60 {
    //第一种解法暴力解法
    //所有排列列出来
    //  List<List<String>> resList = new ArrayList<>();
    List<String> pathList = new ArrayList<>();
    int c = 0;
    String reStr = "";

    public String getPermutation(int n, int k) {
        Permutation(n, k);
        return reStr;
    }

    public void Permutation(int n, int k) {
        if (!"".equals(reStr)){
            return;
        }
        if (pathList.size() == n) {
            //resList.add(new ArrayList<>(pathList));
            c++;
            if (c == k) {
                for (String str : pathList) {
                    reStr = reStr + str;
                }
            }
        }
        for (int j = 1; j <= n; j++) {
            if (pathList.contains("" + j)) {
                continue;
            }
            pathList.add("" + j);
            Permutation(n, k);
            pathList.remove(pathList.size() - 1);
        }
    }

    public static void main(String[] args) {
        //9
        //219601
        System.out.println(new _60().getPermutation(9, 219601));
    }
}
