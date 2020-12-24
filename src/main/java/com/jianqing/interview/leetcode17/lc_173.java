package com.jianqing.interview.leetcode17;

import com.jianqing.interview.base.TreeNode;

import java.util.Stack;

/**
 * Created by jianqing_sun on 1/31/18.
 *
 * Code passed online Judge
 *
 * Binary search tree iterator
 *
 * call next() 的时候，如果当前node 有右子树，就把右child放进去， 然后一路找left放进去， 直到为空
 * hasnext 直接返回stack 是否为空
 */
public class lc_173 {

    TreeNode root = null;
    Stack<TreeNode> stack = new Stack<>();

    public lc_173(TreeNode root) {
        this.root = root;
        if(root != null){
            TreeNode cur = root;
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        int res = node.val;
        TreeNode cur = node.right;
        while(cur != null){
            stack.push(cur);
            cur = cur.left;
        }

        return res;
    }

}
