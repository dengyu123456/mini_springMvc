package com.dy.leetcode._二叉树相关;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
//
//说明: 叶子节点是指没有子节点的节点。
//
//示例:
//给定如下二叉树，以及目标和 sum = 22，
//
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//返回:
//
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/path-sum-ii
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _113NO {
    List<List<Integer>> res = new ArrayList<>();
    //存储路径
    List<Integer> pathList = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return res;
        }
        pathList.add(root.val);
        hasPathSum1(root, sum);
        return res;
    }

    public void hasPathSum1(TreeNode root, int sum) {

        //递归终止条件（是叶子节点）且sum=当前节点的val；
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            //这里加入res
            ArrayList<Integer> resList = new ArrayList<>();
            resList.addAll(pathList);
            res.add(resList);
            return;
        }
        if (root.left != null) {
            pathList.add(root.left.val);
            hasPathSum1(root.left, sum - root.val);
            pathList.remove(pathList.size() - 1);
        }
        if (root.right != null) {
            pathList.add(root.right.val);
            hasPathSum1(root.right, sum - root.val);
            pathList.remove(pathList.size() - 1);
        }

    }

    public static void main(String[] args) {
        Integer[] nums = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        int sum = 22;
        TreeNode treeNode = TreeNodeUtil.createTreeNode(nums);
        new _113NO().pathSum(treeNode, sum);
    }
}
