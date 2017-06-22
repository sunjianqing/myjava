package com.jianqing.interview.leetcode16;

import com.jianqing.interview.base.TreeNode;

import java.util.Stack;

/**
 * Created by jianqing_sun on 6/21/17.
 * 用Inorder 遍历模板
 */
public class ValidateBinarySearchTree_98 {
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
}
