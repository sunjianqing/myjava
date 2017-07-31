package com.jianqing.interview.leetcode16;

import com.jianqing.interview.base.TreeNode;

import java.util.Stack;

/**
 * Created by jianqing_sun on 6/21/17.
 * 用Inorder 遍历模板
 *
 * ！！！如果递归， 不能简单的判断当前节点跟左右children的值得大小关系， 当前节点值必须大于所有左子树节点， 小于所有右子树节点
 */
public class ValidateBinarySearchTree_98 {

    //Recursive
    public boolean isValidBSTRecursive(TreeNode root) {
        return recursiveHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean recursiveHelper(TreeNode node, int min, int max){
        if(node == null){
            return true;
        }

        if(node.val >= max || node.val <= min ){
            return false;
        }

        return recursiveHelper(node.left, min, node.val) && recursiveHelper(node.right, node.val, max);
    }

        // Iterative
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
