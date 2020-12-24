package com.jianqing.interview.facebook.lc20;

import com.jianqing.interview.base.TreeNode;

/**
 * Subtree of Another Tree
 * 题目
 * 一个树是不是另一个的子树
 *
 * preorder 的思想
 * 递归
 *
 */
public class LC_572_SubtreeofAnotherTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        if (s.val != t.val) return false;

        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}

