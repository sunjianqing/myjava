package com.jianqing.interview.leetcode16;

import com.jianqing.interview.base.TreeNode;

import java.util.Stack;

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


    public int sumOfLeftLeavesNonRecursive(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.empty()) {
            TreeNode node = stack.pop();
            if(node.left != null) {
                if (node.left.left == null && node.left.right == null)
                    ans += node.left.val;
                else
                    stack.push(node.left);
            }
            if(node.right != null) {
                if (node.right.left != null || node.right.right != null)
                    stack.push(node.right);
            }
        }
        return ans;
    }

}
