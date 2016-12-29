package com.jianqing.interview.leetcode16;

import com.jianqing.interview.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by jianqingsun on 12/20/16.
 */
public class BinaryTreePreorderTraversal_144 implements Solution {
    @Override
    public void solution() {

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        List<Integer> list = new ArrayList<>();

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            list.add(node.val);

            if (node.right != null)
                stack.push(node.right);

            if (node.left != null) {
                stack.push(node.left);
            }


        }

        return list;
    }
}
