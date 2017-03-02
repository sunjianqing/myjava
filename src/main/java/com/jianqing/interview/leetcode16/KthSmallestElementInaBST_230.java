package com.jianqing.interview.leetcode16;

import com.jianqing.interview.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by jianqingsun on 12/25/16.
 */
public class KthSmallestElementInaBST_230 implements Solution {
    public static void main(String[] args) {
        KthSmallestElementInaBST_230 c = new KthSmallestElementInaBST_230();
        c.solution();
    }
    @Override
    public void solution() {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        node1.left = node2;


        this.kthSmallest(node1, 2);
    }

    public int kthSmallest(TreeNode root, int k) {
        if(root == null )
            return 0;

        List<TreeNode> orderList = new ArrayList();

        inorderTraverse(root, orderList);

        return orderList.get(k-1).val;

    }

    public void inorderTraverse(TreeNode node, List orderList){
        if(node.left == null && node.right == null){
            orderList.add(node);
            return;
        }

        if(node.left != null){
            inorderTraverse(node.left, orderList);
        }

        orderList.add(node);

        if(node.right != null){
            inorderTraverse(node.right, orderList);
        }

    }

    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode p = root;
        int result = 0;

        while(!stack.isEmpty() || p!=null){
            if(p!=null){
                stack.push(p);
                p = p.left;
            }else{
                TreeNode t = stack.pop();
                k--;
                if(k==0)
                    result = t.val;
                p = t.right;
            }
        }

        return result;
    }
}
