package com.leetcode.Tree;

import java.util.*;

public class _652 {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<TreeNode> res = new ArrayList<TreeNode>();
        findDuplicateSubtrees(root, res, map);
        return res;
    }

    private StringBuilder findDuplicateSubtrees(TreeNode root, List<TreeNode> res, Map<String, Integer> map){
        if(root == null){
            return new StringBuilder("$");
        }
        StringBuilder left = findDuplicateSubtrees(root.left, res, map);
        StringBuilder right = findDuplicateSubtrees(root.right, res, map);
        //注意这里的加和顺序
        StringBuilder treeKey = new StringBuilder(root.val + "").append(",").append(left).append(",").append(right);
        map.put(treeKey.toString(), map.getOrDefault(treeKey.toString(), 0) + 1);
        if(map.get(treeKey.toString()) == 2){
            res.add(root);
        }
        return treeKey;
    }
    public static void main(String[] args) {
        //[1,2,3,4,null,2,4,null,null,4,3,4]
        Integer nums[] = {0,0,0,0,null,null,0,null,null,null,0};
        TreeNode treeNode = TreeNodeUtil.createTreeNode(nums);
        new _652().findDuplicateSubtrees(treeNode);
    }
}
