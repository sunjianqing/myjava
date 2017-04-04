package com.jianqing.interview.leetcode16;

import com.jianqing.interview.base.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by jianqingsun on 11/13/16.
 */
public class InvertBinaryTree_226 implements Solution {
    @Override
    public void solution() {
        TreeNode root = new TreeNode(1);
        invertTree(root);

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        else {
            TreeNode invertLeft = invertTree(root.left);
            TreeNode invertRight = invertTree(root.right);

            root.right = invertLeft;
            root.left = invertRight;

            return root;
        }
    }

    // Non recursive
    // 用一个Queue， 先交换， 父结点指针， 然后再入queue
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addFirst(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();

            TreeNode tmp = node.left;

            node.left = node.right;
            node.right = tmp;

            if (node.left != null) queue.addFirst(node.left);
            if (node.right != null) queue.addFirst(node.right);

        }

        return root;
    }


}
