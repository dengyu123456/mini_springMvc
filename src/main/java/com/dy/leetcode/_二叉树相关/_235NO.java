package com.dy.leetcode._二叉树相关;

//给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
//
//百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//
//例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
//
//
//
// 
//
//示例 1:
//
//输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//输出: 6
//解释: 节点 2 和节点 8 的最近公共祖先是 6。
//示例 2:
//
//输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//输出: 2
//解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
// 
//
//说明:
//
//所有节点的值都是唯一的。
//p、q 为不同节点且均存在于给定的二叉搜索树中。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _235NO {
    int min = 0;
    int max = 0;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val <= q.val) {
            min = p.val;
            max = q.val;
        } else {
            min = q.val;
            max = p.val;
        }
        return lowestCommonAncestor(root);
    }

    public TreeNode lowestCommonAncestor(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.val >= min && root.val <= max) {
            return root;
        }
        if (root.val < min) {
            return lowestCommonAncestor(root.right);
        }
        if (root.val > max) {
            return lowestCommonAncestor(root.left);
        }
        return null;
    }

    public static void main(String[] args) {
        Integer[] nums = {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
        TreeNode root = TreeNodeUtil.createTreeNode(nums);
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(4);
        System.out.println(new _235NO().lowestCommonAncestor(root, p, q).val);
    }
}
