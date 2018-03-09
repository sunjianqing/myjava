package com.jianqing.interview.leetcode16;

import com.jianqing.interview.base.TreeNode;

/**
 * Created by jianqing_sun on 3/5/18.
 */
public class SecondMinimumNodeInaBinaryTree_671 {
    public int findSecondMinimumValue(TreeNode root) {

        if (root == null) {
            return -1;
        }

        if (root.left == null && root.right == null) {
            return -1;
        }

        int l = -1;
        if (root.left != null) {
            if (root.left.val == root.val) {
                l = findSecondMinimumValue(root.left);
            } else {
                // 根据题目， 此处一定是root.left.val 大
                l = root.left.val;
            }
        }

        int r = -1;
        if (root.right != null) {
            if (root.right.val == root.val) {
                r = findSecondMinimumValue(root.right);
            } else {
                // 根据题目， 此处一定是root.right.val 大
                r = root.right.val;
            }
        }

        if (r != -1 && l != -1)
            return Math.min(l, r);

        return l == -1 ? r : l;

    }


}
