package com.jianqing.interview.leetcode16;

import com.jianqing.interview.base.TreeNode;

/**
 * Created by jianqingsun on 12/4/16.
 */
public class LowestCommonAncestorofaBinarySearchTree_235 implements Solution {
    @Override
    public void solution() {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null)
            return root;
        if(p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        else if(p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        else
            return root;
    }
}
