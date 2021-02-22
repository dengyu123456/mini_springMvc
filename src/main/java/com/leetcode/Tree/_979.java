package com.leetcode.Tree;

public class _979 {
    int ans = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }

    //规则：只能在父子节点之间移动硬币

    //定义：将左右子节点硬币数变为1  如果是空节点则当成1来处理，
    // root节点是0往上找节点来欠账
    public int dfs(TreeNode root) {
        if (root == null) return 1;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left > 1) {
            root.val = root.val + left - 1;
            ans = ans + left - 1;
        }
        if (right > 1) {
            root.val = root.val + right - 1;
            ans = ans + right - 1;
        }
        if (left <1) {
            root.val = root.val - Math.abs(left)-1;
            ans=ans+Math.abs(left-1);
        }
        if (right <1) {
            root.val = root.val - Math.abs(right)-1;
            ans=ans+Math.abs(right-1);
        }
        return root.val;
    }
}
