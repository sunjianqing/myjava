package com.jianqing.interview.leetcode16;

import com.jianqing.interview.base.TreeNode;

/**
 * Created by jianqingsun on 5/25/17.
 *
 * 如果是满2叉树， 可以通过公式 2^h - 1 直接求 节点数， 如果不是满2叉树， 就递归
 */
public class CountCompleteTreeNodes_222 {

    public static void main(String[] args) {
        CountCompleteTreeNodes_222 c = new CountCompleteTreeNodes_222();
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;

        c.countNodes(root);
    }

    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;

        // 求最左边深度
        int leftHeight = 1;
        TreeNode left = root.left;
        while(left != null) {
            left = left.left;
            leftHeight++;
        }

        // 求最右边深度
        int rightHeight = 1;
        TreeNode right = root.right;
        while(right != null) {
            right = right.right;
            rightHeight++;
        }

        if(leftHeight == rightHeight)
            return (1<<leftHeight) - 1;
        else
            return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
