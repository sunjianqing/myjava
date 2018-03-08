package com.jianqing.interview.leetcode16;


import com.jianqing.interview.base.TreeNode;

import java.util.Stack;

/**
 * Created by jianqingsun on 3/1/17.
 */
public class FlattenBinaryTreetoLinkedList_114 {

    public static void main(String[] args) {
        FlattenBinaryTreetoLinkedList_114 fb = new FlattenBinaryTreetoLinkedList_114();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode5;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        treeNode5.right = treeNode6;

        fb.flatten(treeNode1);

    }

    // again
    public void flatten2(TreeNode root){
        if(root == null)
            return;

        TreeNode node = root;
        while ( node != null ) {

            if(node.left != null){
                // find the right most
                TreeNode rightmost = node.left;
                while(rightmost.right != null){
                    rightmost = rightmost.right;
                }

                rightmost.right = node.right;
                node.right = node.left;
                node.left = null;
            }

            node = node.right;

        }
    }

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        TreeNode foo = new TreeNode(0);
        TreeNode last = foo;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }

            last.right = node;
            last.left = null;
            last = node;
        }

        System.out.println("Done");
    }

}
