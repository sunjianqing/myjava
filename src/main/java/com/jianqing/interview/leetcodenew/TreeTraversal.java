package com.jianqing.interview.leetcodenew;

import com.jianqing.interview.base.TreeNode;

import java.util.Stack;

/**
 * Created by jianqing_sun on 10/2/17.
 */
public class TreeTraversal {

    public void Inorder(TreeNode root){
        if(root == null)
            return;

        TreeNode current = root;
        Stack<TreeNode> stack = new Stack();

        while(current != null || !stack.isEmpty()) {
            if(current != null) {
                stack.push(current);
                current = current.left;
            }
            else{
                TreeNode tmp = stack.pop();
                System.out.println(tmp.val);
                current = tmp.right;
            }
        }

    }

    public void Preorder(TreeNode root){
        if(root == null)
            return;

        Stack<TreeNode> stack = new Stack();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            if(current.right != null){
                stack.push(current.right);
            }

            if(current.left != null){
                stack.push(current.left);
            }
        }
    }

    public void Postorder(TreeNode root) {
        if(root == null) {
            return;
        }


    }
}
