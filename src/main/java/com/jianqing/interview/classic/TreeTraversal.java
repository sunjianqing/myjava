package com.jianqing.interview.classic;

import com.jianqing.interview.base.TreeNode;

import java.util.Stack;

/**
 * Created by jianqing_sun on 5/8/17.
 */
public class TreeTraversal {

    public void PostOrder(TreeNode root) {
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);
        while (!nodes.isEmpty()) {
            TreeNode current = nodes.peek();
            if (current.left == null && current.right == null) { // is Leaf
                TreeNode node = nodes.pop();
                System.out.printf("%s ", node.val);
            } else {
                if (current.right != null) {
                    nodes.push(current.right);
                    current.right = null; // 修改了原数据
                }
                if (current.left != null) {
                    nodes.push(current.left);
                    current.left = null; // 修改了原数据
                }
            }
        }

    }
}
