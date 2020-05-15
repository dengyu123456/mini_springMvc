package com.dy.threadDemo.threadPoolDemo;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int le = in.nextInt();
        List<String> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int max = 0;
        while (in.hasNext()) {
            //输入的时候取出最大数组值
            String replace = in.next().replace(",", "");
            list.add(replace);
            if (replace.length() > max) {
                max = replace.length();
            }
        }
        List<String> stringList = method(le, list, max);
        String result = "";
        for (int i = 0; i < stringList.size(); i++) {
            if (i == stringList.size() - 1) {
                result = result + stringList;
            } else {
                result = result + stringList + ",";
            }
        }
        System.out.println(result);

    }

    public static List<String> method(int le, List<String> list, int max) {
        ArrayList<String> strings = new ArrayList<>();
        int l = 0;
        int r = le;
        while (r < max || list.size() > 0) {
            int oldL = l;
            for (int i = 0; i < list.size(); i++) {
                if (r > list.get(i).length()) {
                    if (l > list.get(i).length()) {
                        strings.add(list.get(i).substring(oldL, list.get(i).length()));
                    } else {
                        strings.add(list.get(i).substring(l, list.get(i).length()));
                    }
                    list.remove(i);
                } else {
                    strings.add(list.get(i).substring(l, r));

                }
            }
            l = r;
            r = r + le;
        }
        return strings;
    }
}
