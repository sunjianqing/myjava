package com.jianqing.interview.classic;

import com.jianqing.interview.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
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

    /*
        Inorder Traversal 模板 可用于 validate bst， 找kth smallest number
     */
    public List Inorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;

        }
        return list;
    }

    public List Inorder2(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while( root != null || !stack.isEmpty()) {
            if(current != null) {
                stack.push(current);
                current = current.left;
            }
            else {
                TreeNode tmp = stack.pop();
                res.add(tmp.val);
                current = tmp.right;
            }
        }

        return res;
    }
}
