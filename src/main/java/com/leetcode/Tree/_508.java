package com.leetcode.Tree;

import java.util.*;

public class _508 {
    Map<Integer, Integer> map = new HashMap<>();
    private int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {

        dfs(root);
        List<Integer> res = new LinkedList<>();
        for(Integer i : map.keySet()){
            if(map.get(i) == max)
                res.add(i);
        }
        int[] resArr = new int[res.size()];
        for(int i = 0;i < res.size();i++){
            resArr[i] = res.get(i);
        }
        return resArr;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int sum = root.val + left + right;
        if (map.containsKey(sum)) {
            map.put(sum, map.get(sum) + 1);
        } else {
            map.put(sum, 1);
        }
        max = Math.max(max,map.get(sum));
        return sum;
    }

    public static void main(String[] args) {
        Integer nums[] = {5,2,-5,5,null,5,6};
        TreeNode treeNode = TreeNodeUtil.createTreeNode(nums);
        new _508().findFrequentTreeSum(treeNode);
    }
}
