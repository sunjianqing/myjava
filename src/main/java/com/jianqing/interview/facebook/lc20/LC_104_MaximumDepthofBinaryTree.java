package com.jianqing.interview.facebook.lc20;

import com.jianqing.interview.base.TreeNode;

public class LC_104_MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int left = 1 + maxDepth(root.left);
        int right = 1 + maxDepth(root.right);

        return Math.max(left, right);
    }
}
