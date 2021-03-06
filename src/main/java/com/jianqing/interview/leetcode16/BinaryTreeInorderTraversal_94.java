package com.jianqing.interview.leetcode16;

import com.jianqing.interview.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by jianqing_sun on 12/19/16.
 *
 */
public class BinaryTreeInorderTraversal_94 implements Solution {
    @Override
    public void solution() {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> lst = new ArrayList<Integer>();

        if(root == null)
            return lst;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        //define a pointer to track nodes
        TreeNode p = root;

        while(!stack.empty() || p != null){

            // if it is not null, push to stack
            //and go down the tree to left
            if(p != null){
                stack.push(p);
                p = p.left;

                // if no left child
                // pop stack, process the node
                // then let p point to the right
            }else{
                TreeNode t = stack.pop();
                lst.add(t.val);
                p = t.right;
            }
        }

        return lst;
    }
}
