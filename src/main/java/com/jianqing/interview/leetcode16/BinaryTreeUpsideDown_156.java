package com.jianqing.interview.leetcode16;

import com.jianqing.interview.base.TreeNode;

/**
 * Created by jianqing_sun on 11/29/17.
 *
 *   1
    / \
   2  3
  / \
 4  5

 =>
     4
    / \
   5  2
     / \
    3  1

 */
public class BinaryTreeUpsideDown_156 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        BinaryTreeUpsideDown_156 btud = new BinaryTreeUpsideDown_156();

        TreeNode updown = btud.updown(root);
        System.out.println(updown.val);

    }

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if ( root == null ){
            return null;
        }

        TreeNode parent = root;
        TreeNode left = root.left;
        TreeNode right = root.right;

        if(left != null){
            TreeNode ret = upsideDownBinaryTree(left);
            left.right = parent;
            left.left = right;
            return ret;
        }

        return root;
    }

    public TreeNode updown(TreeNode root){

        TreeNode pre = root;
        TreeNode cur = root.left;
        if(cur == null)
            return root;

        while(cur.left != null) {
            pre = cur;
            cur = cur.left;
        }

        cur.left = pre.right;
        pre.left = null;
        pre.right = null;
        cur.right = updown(root);

        return cur;

    }
}
