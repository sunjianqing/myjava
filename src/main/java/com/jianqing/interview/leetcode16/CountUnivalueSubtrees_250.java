package com.jianqing.interview.leetcode16;

import com.jianqing.interview.base.TreeNode;

/**
 * Created by jianqing_sun on 1/31/18.
 *
 * post order 思想， 看看左子树都相等不， 看看右子树都相等不， 然后分情况看， 当前节点跟左右子节点的指相等不， 如果相等， 再加1
 * 递归到底的时候return true
 *
 *

 */
public class CountUnivalueSubtrees_250 {
    public static void main(String[] args) {
        CountUnivalueSubtrees_250 c = new CountUnivalueSubtrees_250();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        int i = c.countUnivalSubtrees(root);
        System.out.println("count is " + i);
    }
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        helper(root, count);
        return count[0];
    }

    private boolean helper(TreeNode node, int[] count) {
        if (node == null) {
            return true;
        }
        boolean left = helper(node.left, count);
        boolean right = helper(node.right, count);
        if (left && right) {
            if (node.left != null && node.val != node.left.val) {
                return false;
            }
            if (node.right != null && node.val != node.right.val) {
                return false;
            }
            count[0]++;
            return true;
        }
        return false;
    }

}
