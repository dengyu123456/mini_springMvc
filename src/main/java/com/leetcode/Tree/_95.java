package com.leetcode.Tree;


import java.util.ArrayList;
import java.util.List;

public class _95 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> pathList = new ArrayList<>();
    boolean visti[] = null;

    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return null;
        }
        List<TreeNode> resList = new ArrayList<>();
        int nums[] = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }

        visti = new boolean[n];
        permute1(nums);
        for (List<Integer> list : res) {
            TreeNode treeNode = generateRoot(list);
            resList.add(treeNode);
        }
        return resList;
    }

    public void permute1(int[] nums) {
        if (pathList.size() == nums.length) {
            List<Integer> list = new ArrayList<>();
            list.addAll(pathList);
            res.add(list);
        }
        for (int i = 0; i < nums.length; i++) {
            if (visti[i]) {
                continue;
            }
            visti[i] = true;
            pathList.add(nums[i]);
            permute1(nums);
            pathList.remove(pathList.size() - 1);
            visti[i] = false;
        }
    }

    public TreeNode generateRoot(List<Integer> list) {
        TreeNode root = new TreeNode(list.get(0));
        for (int i=1;i< list.size();i++) {
            put(root, list.get(i));
        }
        return root;

//        TreeNode root = new TreeNode(nums[0]);
//        for (int i = 1; i < nums.length; i++) {
//            put(root, nums[i]);
//        }
//        return root;
    }

    private TreeNode put(TreeNode root, int n) {
        if (root == null) return new TreeNode(n);
        if (n < root.val) {
            root.left = put(root.left, n);
        } else {
            root.right = put(root.right, n);
        }
        return root;
    }

    public static void main(String[] args) {
        _95 a = new _95();
        a.generateTrees(3);

//        int a[] = {2, 35, 23, 12, 1};
//        TreeNode treeNode = new TreeNode(2);
//        _95 b = new _95();
//        for (int i = 0; i < a.length; i++) {
//            b.put(treeNode, a[i]);
//        }
//        treeNode.getVal();
    }
}
