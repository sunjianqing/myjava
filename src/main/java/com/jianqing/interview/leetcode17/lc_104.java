package com.jianqing.interview.leetcode17;

import com.jianqing.interview.base.TreeNode;

/**
 * Created by jianqingsun on 11/13/17.
 *
 * Maximum Depth of Binary Tree
 *
 */
public class lc_104 {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int left = root.left == null ? 0 : 1 + maxDepth(root.left);
        int right = root.right == null ? 0 : 1 + maxDepth(root.right);
        return Math.max(left, right);
    }

}
