package com.jianqing.interview.facebook;

import com.jianqing.interview.base.TreeNode;

import java.util.Stack;

/**
 * Created by jianqingsun on 8/3/17.
 */
public class BinaryTreeDoublyLinkedList {


    public DoublyListNode bstToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }

        //Init stack
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        stack.push(node);
        //Create DoublyListNode header
        DoublyListNode dummy = new DoublyListNode(0);
        DoublyListNode dNode = dummy;

        while(!stack.isEmpty()) {
            while (node != null && node.left != null) {
                stack.push(node.left);
                node = node.left;
            }

            //add node
            node = stack.pop();
            DoublyListNode curr = new DoublyListNode(node.val);
            dNode.next = curr;
            curr.prev = dNode;
            dNode = dNode.next;

            // right
            node = node.right;
            if (node != null) {
                stack.push(node);
            }

        }

        return dummy.next;

    }
}

class DoublyListNode {
    int val;
    DoublyListNode next, prev;

    DoublyListNode(int val) {
        this.val = val;
        this.next = this.prev = null;
    }
}
