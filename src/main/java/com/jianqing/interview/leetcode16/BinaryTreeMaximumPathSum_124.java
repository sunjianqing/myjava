package com.jianqing.interview.leetcode16;

import com.jianqing.interview.base.TreeNode;

/**
 * Created by jianqingsun on 8/24/17.
 * <p>
 * http://bangbingsyb.blogspot.com/2014/11/leetcode-binary-tree-maximum-path-sum.html
 * <p>
 * 按路径种类分类
 * 1 是以root 为起点的
 * 2 是经过root的 左右 path 一起的
 * 注意， 如果左右路径有负的， 就取0
 *
 *
 * 记住！！！ helper 回来的不是子问题的解，是子问题的一个单边path的值！全局解是在递归过程中更新的！
 */
public class BinaryTreeMaximumPathSum_124 {

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    public int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        //连接父节点的最大路径是一、二、四这三种情况的最大值
        int currSum = Math.max(Math.max(left + root.val, right + root.val), root.val);
        //当前节点的最大路径是一、二、三、四这四种情况的最大值
        int currMax = Math.max(currSum, left + right + root.val);
        //用当前最大来更新全局最大
        max = Math.max(currMax, max);
        return currSum;
    }
}
