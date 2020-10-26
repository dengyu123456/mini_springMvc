package com.dy.leetcode._图相关;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

//和126相关，126以后做知识点很广
public class _127NO {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        //1、先比较beginWord能不能变化一个字母变为字典当中的值
        List<String> firstList = new ArrayList<>();
        boolean f = true;
        for (int i = 0; i < wordList.size(); i++) {
            if (differenceStr(beginWord, wordList.get(i))) {
                firstList.add(wordList.get(i));
                f = false;
            }
        }
        if (f) {
            return 0;
        }
        //存储图   将字典按照变化一个字母即可变为字典中的另一个值的关系组成图
        Map<String, List<String>> map = new HashMap<>();
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < wordList.size(); i++) {
            String a = wordList.get(i);
            for (int j = 0; j < wordList.size(); j++) {
                if (j != i) {
                    String b = wordList.get(j);
                    if (differenceStr(a, b)) {
                        strings.add(b);
                    }
                }
            }
            if (!strings.isEmpty()) {
                map.put(a, strings);
            }
            strings = new ArrayList<>();
        }
        if (map.isEmpty() && !(wordList.size() == 1 && endWord.equals(wordList.get(0)))) {
            return 0;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < firstList.size(); i++) {
            //遍历firstList当中的值在图中到endWord的最短路径，dfs深度优先遍历寻路找到firstList中的值到end的所有路径

            ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
            //记录遍历过的值和第几层
            Map<String, Integer> visitMap = new HashMap<>();
            //要寻路的值
            String s = firstList.get(i);
            queue.add(s);
            int count = 1;
            visitMap.put(s, count);
            boolean flag = true;
            while (!queue.isEmpty() && flag) {

                String poll = queue.poll();
                if (endWord.equals(poll)) {
                    list.add(visitMap.get(poll));
                    flag = false;
                    continue;
                }
                //出队列时将该节点的相邻节点入队列
                if (!map.containsKey(poll)) {
                    return 0;
                }
                List<String> noVisitList = map.get(poll);
//                count++;
                for (int j = 0; j < noVisitList.size() && flag; j++) {
                    //如果没有访问过
                    if (!visitMap.containsKey(noVisitList.get(j))) {
                        queue.add(noVisitList.get(j));
                        visitMap.put(noVisitList.get(j), visitMap.get(poll) + 1);
                    }
                    if (endWord.equals(noVisitList.get(j))) {
                        list.add(visitMap.get(poll) + 1);
                        flag = false;
                        continue;
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        if (list.isEmpty()) {
            return 0;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < min) {
                min = list.get(i);
            }
        }
        return min + 1;
    }

    //比较两个字符串是否相差一个单词不一样 hot和dot
    public boolean differenceStr(String a, String b) {
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        int count = 0;
        for (int i = 0; i < aArr.length; i++) {
            if (aArr[i] != bArr[i]) {
                count++;
            }
        }
        return count < 2;
    }

    public static void main(String[] args) {
        //"a"
        //"c"
        //["a","b","c"]

        //"hot"
        //"dog"
        //["hot","dog"]
        //"talk"
        //"tail"
        //["talk","tons","fall","tail","gale","hall","negs"]

        //"hit"
        //"cog"
        //["hot","dot","tog","cog"]

        //"hog"
        //"cog"
        //["cog"]
        String beginWord = "hog";
        String endWord = "cog";
        String[] wordArr = {"cog"};
//        String beginWord = "hit";
//        String endWord = "cog";
//        String[] wordArr = {"hot", "dot", "dog", "lot", "log", "cog"};
//        String beginWord = "a";
//        String endWord = "c";
//        String[] wordArr = {"a","b","c"};
        List<String> wordList = new ArrayList<>();
        for (int i = 0; i < wordArr.length; i++) {
            wordList.add(wordArr[i]);
        }
        new _127NO().ladderLength(beginWord, endWord, wordList);
    }
}
