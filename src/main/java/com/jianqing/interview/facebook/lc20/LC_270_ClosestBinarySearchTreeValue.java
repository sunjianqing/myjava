package com.jianqing.interview.facebook.lc20;

import com.jianqing.interview.base.TreeNode;

/**
 * 类似中序遍历
 * 可以放个全局变量记录结果
 * https://nifannn.github.io/2019/02/14/Algorithm-Notes-Leetcode-270-Closest-Binary-Search-Tree-Value/#java-implementation
 *
 * 看下面解法 closestValue2
 * 当前root 大，就不用检查right 了， 因为离的更远
 * 如果当前root 小， 就去right， 因为left 离的更远
 */
public class LC_270_ClosestBinarySearchTreeValue {

    public static void main(String[] args) {
        LC_270_ClosestBinarySearchTreeValue lc = new LC_270_ClosestBinarySearchTreeValue();

        TreeNode root = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5);
        TreeNode node8 = new TreeNode(8);

        root.left = node2;
        root.right = node6;
        node6.left = node5;
        node6.right = node8;

        int res = lc.closestValue(5.1f, root);
        System.out.println(res);
    }

    public int closestValue(float target, TreeNode root) {

        if (root == null) {
            return 0;
        }

        return helper(target, root, root.val);
    }

    private int helper(float target, TreeNode node, int res) {
        if (node == null) {
            return res;
        }

        if (Math.abs(target - node.val) < Math.abs(target - res)) {
            res = node.val;
        }

        if (target > node.val) {
            res = helper(target, node.right, res);
        } else {
            res = helper(target, node.left, res);
        }

        return res;
    }


    public int closestValue2(float target, TreeNode root) {

        int res = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(res - target)) res = root.val;

            if (root.val > target) {
                root = root.left;
            }
            else {
                root = root.right;
            }
        }

        return res;
    }
}
