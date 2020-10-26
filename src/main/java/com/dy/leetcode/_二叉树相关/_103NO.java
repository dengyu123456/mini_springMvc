package com.dy.leetcode._二叉树相关;
/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class _103NO {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        Queue<TreeNode> queue = new ConcurrentLinkedQueue<>();
        //val表示第几层 1左->右  2：右->左 3左->右   奇数层：左->右 偶数层：右->左
        Map<TreeNode, Integer> map = new HashMap<>();
        int count = 1;
        queue.add(root);
        map.put(root, count);
        Map<Integer, ArrayList<Integer>> resMap = new HashMap<>();
        List<Integer> firstList = new ArrayList<>();
        firstList.add(root.val);
        resList.add(firstList);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            //如果是偶数
            count = map.get(poll) + 1;
//            if (count % 2 == 0) {
//                if (poll.right != null) {
//                    queue.add(poll.right);
//                    map.put(poll.right, count);
//                    if (resMap.containsKey(count)) {
//                        ArrayList<Integer> list = resMap.get(count);
//                        list.add(poll.right.val);
//                    } else {
//                        ArrayList<Integer> list = new ArrayList<>();
//                        list.add(poll.right.val);
//                        resMap.put(count, list);
//                    }
//                }
//                if (poll.left != null) {
//                    queue.add(poll.left);
//                    map.put(poll.left, count);
//                    if (resMap.containsKey(count)) {
//                        ArrayList<Integer> list = resMap.get(count);
//                        list.add(poll.left.val);
//                    } else {
//                        ArrayList<Integer> list = new ArrayList<>();
//                        list.add(poll.left.val);
//                        resMap.put(count, list);
//                    }
//                }
//            } else {
            if (poll.left != null) {
                queue.add(poll.left);
                map.put(poll.left, count);
                if (resMap.containsKey(count)) {
                    ArrayList<Integer> list = resMap.get(count);
                    list.add(poll.left.val);
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(poll.left.val);
                    resMap.put(count, list);
                }
            }
            if (poll.right != null) {
                queue.add(poll.right);
                map.put(poll.right, count);
                if (resMap.containsKey(count)) {
                    ArrayList<Integer> list = resMap.get(count);
                    list.add(poll.right.val);
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(poll.right.val);
                    resMap.put(count, list);
                }
            }
        }
        // }
        for (Integer key : resMap.keySet()) {
            if (key % 2 == 0) {
                ArrayList<Integer> list = resMap.get(key);
                List<Integer> integerList = new ArrayList<>();
                for (int i = list.size() - 1; i >= 0; i--) {
                    integerList.add(list.get(i));
                }
                resList.add(integerList);
            } else {
                resList.add(resMap.get(key));
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        Integer[] root = {1, 2, 3, 4, null, null, 5};
        TreeNode treeNode = TreeNodeUtil.createTreeNode(root);
        new _103NO().zigzagLevelOrder(treeNode);
    }
}
