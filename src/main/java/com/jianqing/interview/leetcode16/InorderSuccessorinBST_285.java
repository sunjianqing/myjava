package com.jianqing.interview.leetcode16;

import com.jianqing.interview.base.TreeNode;

/**
 * Created by jianqing_sun on 7/31/17.
 */
public class InorderSuccessorinBST_285 {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null){
            return null;
        }

        // 这段没用
//        if(p.right != null) {
//            // find left most
//            TreeNode node = p.right;
//            while(node.left != null) {
//                node = node.left;
//            }
//            return node;
//        }

        TreeNode successor = null;
        while(root != null) {
            if(p.val < root.val) {
                successor = root;
                root = root.left;
            }
            else {
                root = root.right; // 相等的时候， root 就变成了null
            }
        }

        return successor;

    }
}
