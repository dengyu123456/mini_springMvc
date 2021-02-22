package com.leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

public class _872 {
    List<Integer> list = new ArrayList<>();
    int index = 0;
    boolean flag = true;

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        dfs1(root1);
        dfs2(root2);
        if (index!=list.size()){
            return false;
        }
        return flag;
    }

    public void dfs1(TreeNode root1) {
        if (root1 == null) return;
        dfs1(root1.left);
        dfs1(root1.right);
        if (root1.left == null && root1.right == null) {
            list.add(root1.val);
        }
    }

    public void dfs2(TreeNode root2) {
        if (!flag) return;
        if (root2 == null) return;
        dfs2(root2.left);
        dfs2(root2.right);
        if (root2.left == null && root2.right == null) {
            if (index<list.size()&&list.get(index) == root2.val) {
                index++;
            } else {
                flag = false;
            }
        }

    }

    public static void main(String[] args) {
        //[3,5,1,6,7,4,2,null,null,null,null,null,null,9,11,null,null,8,10]
        //[3,5,1,6,2,9,8,null,null,7,4]
        Integer []nums1={3,5,1,6,7,4,2,null,null,null,null,null,null,9,11,null,null,8,10};
        Integer []nums2={3,5,1,6,2,9,8,null,null,7,4};
        TreeNode treeNode1 = TreeNodeUtil.createTreeNode(nums1);
        TreeNode treeNode2 = TreeNodeUtil.createTreeNode(nums2);
        new _872().leafSimilar(treeNode1,treeNode2);
    }
}
