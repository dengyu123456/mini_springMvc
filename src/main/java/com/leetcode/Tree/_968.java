package com.leetcode.Tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _968 {
    int ans = 0;

    public int minCameraCover(TreeNode root) {
        if (root == null) return 0;

        if (dfs(root) == 0) {
            ans++;
        }
        return ans;
    }

    //函数定义：返回值1：该节点可以观测 0：该节点不可观测 2：该节点是相机

    //状态转移：如果是null节点，默认可以观测
    public int dfs(TreeNode root) {
        if (root == null) return 1;
        int left = dfs(root.left);
        int right = dfs(root.right);

        //如果左右子节点是被观测状态，则当前节点一定是观测不到的
        if (left == 1 && right == 1) {
            return 0;
        }
        //如果左右子节点有一个观测不到，则当前节点变为相机
        if (left == 0 || right == 0) {
            ans++;
            return 2;
        }
        //如果左右节点有一个是相机则root节点一定被观测到
        if (left == 2 || right == 2) {
            return 1;
        }
        return 0;
    }


}
