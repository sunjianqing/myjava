package com.jianqing.interview.leetcode16;

import com.jianqing.interview.base.TreeNode;

/**
 * Created by jianqing_sun on 8/20/17.
 *
 * 算高度的时候， 把最大直径也算了
 *
 * 递归回来的是子问题的高度！！！ 不是子问题的解
 */
public class DiameterofBinaryTree_543 {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }
}


