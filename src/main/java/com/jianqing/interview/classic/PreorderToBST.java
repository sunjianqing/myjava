package com.jianqing.interview.classic;

import com.jianqing.interview.base.TreeNode;

import java.util.Stack;


/*
 * Give you a preorder array , generate a BST
 * Created by jianqing_sun on 2/27/17.
 */
public class PreorderToBST {

    // Stack 方法
    public TreeNode buildBST(int array[]){
        TreeNode root = new TreeNode(array[0]);

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        for ( int i = 1 ; i < array.length ; i++) {

            TreeNode tmp = null;

            while ( !stack.isEmpty() && array[i] > stack.peek().val ) {
                tmp = stack.pop();
                // stack 为空的时候， tmp 是root
            }

            // Make this greater value as the right child and push it to the stack
            if( tmp !=  null){
                TreeNode right = new TreeNode(array[i]);
                tmp.right = right;
                stack.push(tmp.right);
            }
            else {
                // If the next value is less than the stack's top value, make this value
                // as the left child of the stack's top node. Push the new node to stack
                TreeNode peek = stack.peek();
                peek.left = new TreeNode(array[i]);
                stack.push(peek.left);
            }
        }

        return root;

    }
}
