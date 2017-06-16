package com.jianqing.interview.leetcode16;

import com.jianqing.interview.base.TreeNode;

/**
 * Created by jianqing_sun on 4/17/17.
 */
public class InorderPostorderToTree_106 {

    public static void main(String[] args) {
        InorderPostorderToTree_106 ip = new InorderPostorderToTree_106();
        int[] inorder = new int[]{1, 3, 2};
        int[] postorder = new int[]{3, 2, 1};
        TreeNode treeNode = ip.buildTree(inorder, postorder);
        System.out.println(treeNode.val);

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0)
            return null;

        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int instart, int inend, int postart, int poend) {
        if (inend < instart || poend < postart)
            return null;

        int val = postorder[poend];
        TreeNode root = new TreeNode(val);
        int index = 0;
        for (int i = instart; i <= inend; i++) {
            if (inorder[i] == val) {
                index = i;
                break;
            }
        }

        root.left = helper(inorder, postorder, instart, index - 1, postart, index - 1 - instart + postart);
        root.right = helper(inorder, postorder, index + 1, inend, postart + index - instart, poend - 1);

        return root;
    }
}
