package com.jianqing.interview.leetcode16;

import com.jianqing.interview.leetcode.TreeNode;

/**
 * Created by jianqing_sun on 12/12/16.
 *
 * 得判断每一个节点的左右子树之差 都不大于1
 */
public class BalancedBinaryTree_110 implements Solution {
    @Override
    public void solution() {

    }

    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;

        if (finddepth(root) == -1)
            return false;

        return true;
    }

    public int finddepth(TreeNode node){
        if(node == null)
            return 0;

        int left = finddepth(node.left);
        int right = finddepth(node.right);

        if (left == -1 || right == -1)
            return -1;

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }
}
