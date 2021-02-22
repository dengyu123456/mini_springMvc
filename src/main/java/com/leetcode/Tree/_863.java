package com.leetcode.Tree;

import java.util.*;

public class _863 {
    static TreeNode targetNode;

    Map<TreeNode, TreeNode> f = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    Set<TreeNode> visit = new HashSet<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        dfs(root, null);
        dfs(target, K);
        TreeNode treeNode = f.get(target);
        visit.add(target);
        while (treeNode != null && K > -1) {
            K--;
            dfs(treeNode, K);
            visit.add(treeNode);
            treeNode = f.get(treeNode);

        }
        return list;
    }

    public void dfs(TreeNode root, int k) {
        if (visit.contains(root)){
            return;
        }
        if (root == null) return;
        if (k == 0 ) {
            list.add(root.val);
        }
        dfs(root.left, k - 1);
        dfs(root.right, k - 1);
    }

    //前序遍历记录节点的父节点
    public void dfs(TreeNode root, TreeNode pre) {
        if (root == null) return;
        f.put(root, pre);
        dfs(root.left, root);
        dfs(root.right, root);
    }

    public static void main(String[] args) {
        Integer[] nums = {0,2,1,null,null,3};
        TreeNode treeNode = TreeNodeUtil.createTreeNode(nums);
        //TreeNode tager = new TreeNode(5);
        getTager(treeNode,3);
        new _863().distanceK(treeNode, targetNode, 3);
    }
    public static void getTager(TreeNode root,int val){
        if (root==null) return ;
        if (root.val==val)
            targetNode=root;
        getTager(root.left,val);
        getTager(root.right,val);
    }
}
