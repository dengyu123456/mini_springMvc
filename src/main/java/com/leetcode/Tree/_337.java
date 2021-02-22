package com.leetcode.Tree;

import org.junit.internal.builders.NullBuilder;

import java.util.HashMap;
import java.util.Map;

public class _337 {

    //定义两个map
    //f表示当前节点0被选中的最大值
    Map<TreeNode, Integer> f = new HashMap<>();
    //g表示当前节点0不被选中的最大值
    Map<TreeNode, Integer> g = new HashMap<>();

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(g.getOrDefault(root,0), f.getOrDefault(root,0));
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        dfs(root.right);
        //当root被选中的时候 则他的孩子节点不能被选中 f(o)=g(l)+g(r)

        f.put(root, root.val + g.getOrDefault(root.left, 0) + g.getOrDefault(root.right, 0));
        //当root不被选中的时候 选择左右节点的最大值,左右节点可以选中也可以不选中取最大值的和
        g.put(root, Math.max(f.getOrDefault(root.left, 0), g.getOrDefault(root.left, 0)) + Math.max(f.getOrDefault(root.right, 0), g.getOrDefault(root.right, 0)));
    }

    public static void main(String[] args) {
        Integer nums1[] = {3, 2, 3, null, 3, null, 1};
        TreeNode treeNode = TreeNodeUtil.createTreeNode(nums1);
        new _337().rob(treeNode);
    }
}

