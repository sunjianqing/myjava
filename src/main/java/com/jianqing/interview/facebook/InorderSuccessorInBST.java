package com.jianqing.interview.facebook;

import com.jianqing.interview.base.TreeNode;

/**
 * Created by jianqingsun on 8/1/17.
 */
public class InorderSuccessorInBST {

    public TreeNode successor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        TreeNode succ = null;

        while (root != null) {
            if (p.val < root.val) {
                succ = root;
                root = root.left;
            } else {
                // 如果遇到了p， p有右子树， 就一路找下去， 找到最左端， 那个结点会使root 为null， 然后退出
                // 如果遇到了p， p没有右子树，最近的被设置过的succ 就是结果
                // 如果没遇到p，就继续在右边找
                root = root.right;
            }
        }

        return succ;

    }
}
