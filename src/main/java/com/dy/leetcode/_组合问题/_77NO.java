package com.dy.leetcode._组合问题;

import java.util.ArrayList;
import java.util.List;

public class _77NO {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> pathList = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        combine1(n, k,1);
        return res;
    }

    public void combine1(int n, int k,int min) {
        if(pathList.size() >k){
            return;
        }
        if (pathList.size() == k) {
            List<Integer> list = new ArrayList<>();
            list.addAll(pathList);
            res.add(list);
        }
        for (int i = min; i <= n; i++) {
            pathList.add(i);
            combine1(n, k,i+1);
            pathList.remove(pathList.size() - 1);
        }

    }

    public static void main(String[] args) {
        new _77NO().combine(4, 2);
    }

}
