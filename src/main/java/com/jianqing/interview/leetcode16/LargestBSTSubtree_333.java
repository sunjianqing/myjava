package com.jianqing.interview.leetcode16;

import com.jianqing.interview.base.TreeNode;

/**
 * Created by jianqingsun on 2/12/18.
 *
 * Largest BST subtree
 *
 * Method 1 validate left bst and right bst, then root
 * Method 2 Bottom Up 记录左子树的最大值， root 得比它大， 记录右子树的最小值， root 得比它小， 这个得需要个辅助类
 */
public class LargestBSTSubtree_333 {
    static class TrackNode{
        int size;
        int min;
        int max;
        boolean isBST;

        public TrackNode() {
            size = 0;
            min = Integer.MIN_VALUE;
            max = Integer.MAX_VALUE;
            size = 0;
        }
    }

    public int largestBSTSubtree(TreeNode root) {
        return helper(root).size;
    }

    public TrackNode helper(TreeNode root) {

        TrackNode curr = new TrackNode();

        if(root == null){
            curr.isBST = true;
            return curr;
        }

        TrackNode l = helper(root.left);
        TrackNode r = helper(root.right);

        //current subtree's boundaries
        curr.min = Math.min(root.val, l.min);
        curr.max = Math.max(root.val, r.max);

        //check left and right subtrees are BST or not
        //check left's upper again current's value and right's lower against current's value
        if(l.isBST && r.isBST && root.val >= l.max && root.val <= r.min){
            curr.size = l.size + 1 + r.size;
            curr.isBST = true;
        }
        else{
            curr.isBST = false;
            curr.size = Math.max(l.size, r.size);
        }

        return curr;
    }

}

