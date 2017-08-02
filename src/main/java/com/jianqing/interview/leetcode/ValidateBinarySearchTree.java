package com.jianqing.interview.leetcode;

import com.jianqing.interview.base.TreeNode;

/**
 * Created by jianqsun on 3/26/14.
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        boolean result = true;

        if(root == null){
            return true;
        }
        else{
            if(root.left != null){
                result = result && root.val > root.left.val;
                result = result && isValidBST(root.left);
            }

            if(root.right != null){
                result = result && root.val < root.right.val;
                result = result && isValidBST(root.right);
            }
        }

        return result;
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
