package com.leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

public class _894 {

    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();
        if (N % 2 == 0) return res;
        if (N == 1) {
            TreeNode treeNode = new TreeNode(0);
            res.add(treeNode);
            return res;
        }
        for (int i = 1; i < N; i++) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - i - 1);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode treeNode = new TreeNode(0);
                    treeNode.left = l;
                    treeNode.right = r;
                    res.add(treeNode);
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        List<TreeNode> treeNodes = new _894().allPossibleFBT(7);
        System.out.println("0");
    }
}
