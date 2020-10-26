package com.dy.leetcode._二叉树相关;

//给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
//
//说明: 叶子节点是指没有子节点的节点。
//
//示例: 
//给定如下二叉树，以及目标和 sum = 22，
//
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
//返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/path-sum
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _112NO {
    boolean isHave = false;

    public boolean hasPathSum(TreeNode root, int sum) {
        hasPathSum1(root, sum);
        return isHave;
    }

    public void hasPathSum1(TreeNode root, int sum) {
        if (isHave) {
            return;
        }
        //递归终止条件（是叶子节点）且sum=当前节点的val；
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            isHave = true;
            return;
        }
        if (root.left != null) {
            hasPathSum1(root.left, sum - root.val);
        }
        if (root.right != null) {
            hasPathSum1(root.right, sum - root.val);
        }

    }

    public static void main(String[] args) {
        Integer[] nums = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
        int sum = 22;
        TreeNode root = TreeNodeUtil.createTreeNode(nums);
        new _112NO().hasPathSum(root, sum);
    }
}
