package com.jianqing.interview.leetcode16;

import com.jianqing.interview.base.TreeNode;

import java.util.*;

/**
 * Created by jianqingsun on 11/13/17.
 */
public class BinaryTreeZigzagLevelOrderTraversal_103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null)
            return res;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        boolean order = true;
        int size = 1;

        while (!q.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode n = q.poll();
                if (order) {
                    tmp.add(n.val);
                } else {
                    tmp.add(0, n.val);
                }
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
            res.add(tmp);
            size = q.size();
            order = order ? false : true;
        }
        return res;
    }
}
