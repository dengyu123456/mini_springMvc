package com.leetcode.Tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1028 {

    Map<String, List<String>> map = new HashMap<>();

    public TreeNode recoverFromPreorder(String S) {
        String rootStr = S.substring(0, 1);
        TreeNode root = new TreeNode(Integer.valueOf(rootStr));
        //将

        return root;
    }

    public static void main(String[] args) {
        new _1028().recoverFromPreorder("1");
    }

}
