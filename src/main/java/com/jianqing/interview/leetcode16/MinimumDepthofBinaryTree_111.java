package com.jianqing.interview.leetcode16;

import com.jianqing.interview.base.TreeNode;

/**
 * Created by jianqing_sun on 7/18/17.
 * <p>
 * 注意子树为空的情况， 应该search 另一支
 */
public class MinimumDepthofBinaryTree_111 {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        //注意这一行
        if (left == 0 || right == 0)
            return left + right + 1;
        else
            return 1 + Math.min(left, right);
    }
}
