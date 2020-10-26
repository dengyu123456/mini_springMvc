package com.dy.leetcode._二叉树相关;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

//给定一个二叉树，它的每个结点都存放着一个整数值。
//
//找出路径和等于给定数值的路径总数。
//
//路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
//
//二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
//
//示例：
//
//root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//返回 3。和等于 8 的路径有:
//
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3.  -3 -> 11
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/path-sum-iii
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _437NO {
//    List<List<Integer>> res = new ArrayList<>();
//    //存储路径
//    List<Integer> pathList = new ArrayList<>();
//
//    public int pathSum(TreeNode root, int sum) {
//        if (root == null) {
//            return 0;
//        }
//        Queue<TreeNode> queue = new ConcurrentLinkedQueue<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            TreeNode poll = queue.poll();
//            pathList.add(poll.val);
//            pathSum1(poll, sum);
//            pathList.remove(pathList.size() - 1);
//            if (poll.right != null) {
//                queue.add(poll.right);
//            }
//            if (poll.left != null) {
//                queue.add(poll.left);
//            }
//        }
//
//        return res.size();
//    }
//
//    public void pathSum1(TreeNode root, int sum) {
//        if (root == null) {
//            return;
//        }
//        if (sum == root.val) {
//            ArrayList<Integer> list = new ArrayList<>();
//            list.addAll(pathList);
//            res.add(list);
//        }
//        if (root.left != null) {
//            pathList.add(root.left.val);
//            pathSum1(root.left, sum - root.val);
//            pathList.remove(pathList.size() - 1);
//        }
//        if (root.right != null) {
//            pathList.add(root.right.val);
//            pathSum1(root.right, sum - root.val);
//            pathList.remove(pathList.size() - 1);
//        }
//    }

    //广度加深度遍历
    int count = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            pathSum1(poll, sum);
            if (poll.right != null) {
                queue.add(poll.right);
            }
            if (poll.left != null) {
                queue.add(poll.left);
            }
        }

        return count;
    }

    public void pathSum1(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (sum == root.val) {
            count++;
        }
        if (root.left != null) {
            pathSum1(root.left, sum - root.val);
        }
        if (root.right != null) {
            pathSum1(root.right, sum - root.val);
        }
    }

    public static void main(String[] args) {
        //[10,5,-3,3,2,null,11,3,-2,null,1]
        //8
        Integer[] nums = {1};
        TreeNode treeNode = TreeNodeUtil.createTreeNode(nums);
        new _437NO().pathSum(treeNode, 1);


    }
}
