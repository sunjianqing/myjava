package com.jianqing.interview.leetcode;

import com.jianqing.interview.base.TreeNode;

import java.util.Stack;

/**
 * Created by jianqsun on 3/26/14.
 */
public class ValidateBinarySearchTree {

    //Recursive
    public boolean isValidBSTRecursive(TreeNode root) {
        return recursiveHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean recursiveHelper(TreeNode node, int min, int max){
        if(node == null){
            return true;
        }

        if(node.val >= max || node.val <= min ){
            return false;
        }

        return recursiveHelper(node.left, min, node.val) && recursiveHelper(node.right, node.val, max);
    }

    // Iterative
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;

        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        TreeNode pre = null;
        while(!stack.isEmpty() || cur != null){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            else{
                TreeNode p = stack.pop();

                // 这里是模板中需要加的3行
                if(pre != null && pre.val >= p.val)
                    return false;
                pre = p;

                cur = p.right;
            }
        }

        return true;
    }

    public static void main(String[] args){
        ValidateBinarySearchTree vbst = new ValidateBinarySearchTree();
        TreeNode tn1 = new TreeNode(10);
        TreeNode tn2 = new TreeNode(9);
        TreeNode tn3 = new TreeNode(17);
        tn1.left = tn2;
        tn1.right = tn3;

        TreeNode tn4 = new TreeNode(5);
        tn2.left = tn4;

        Boolean res = vbst.isValidBST(tn1);
        System.out.println("result is " + res);

    }
}
