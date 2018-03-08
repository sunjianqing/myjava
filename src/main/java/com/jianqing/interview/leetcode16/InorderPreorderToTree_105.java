package com.jianqing.interview.leetcode16;

import com.jianqing.interview.base.TreeNode;

/**
 * Created by jianqingsun on 4/17/17.
 */
public class InorderPreorderToTree_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0)
            return null;

        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {

        if (preEnd < preStart || inEnd < inStart)
            return null;

        int val = preorder[preStart];
        TreeNode root = new TreeNode(val);
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == val) {
                index = i;
                break;
            }
        }

        root.left = helper(preorder, inorder, preStart + 1, preStart + index - inStart, inStart, index - 1);
        root.right = helper(preorder, inorder, preStart + index - inStart + 1, preEnd, index + 1, inEnd);

        return root;
    }

}
