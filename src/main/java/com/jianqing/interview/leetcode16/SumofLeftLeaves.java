package com.jianqing.interview.leetcode16;

import com.jianqing.interview.leetcode.TreeNode;

/**
 * Created by jianqing_sun on 11/28/16.
 */
public class SumofLeftLeaves implements Solution {
    @Override
    public void solution() {

    }

    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null)
            return 0;

        if (root.left == null)
            return sumOfLeftLeaves(root.right);
        else {
            if (root.left.left == null && root.left.right == null) {
                return root.left.val + sumOfLeftLeaves(root.right);
            }
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }

    }


}
