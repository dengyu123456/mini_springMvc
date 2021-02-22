package com.leetcode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _173 {
    static class BSTIterator {
        LinkedList<Integer> res = new LinkedList<>();


        public BSTIterator(TreeNode root) {
            LDR(root);
        }

        private void LDR(TreeNode root) {
            if (root == null) return;
            LDR(root.left);
            res.add(root.val);
            LDR(root.right);
        }

        public int next() {
            return res.removeFirst();
        }

        public boolean hasNext() {
            return !res.isEmpty();
        }
    }
}
