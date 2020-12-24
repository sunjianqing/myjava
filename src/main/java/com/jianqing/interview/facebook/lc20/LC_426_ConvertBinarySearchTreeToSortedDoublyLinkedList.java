package com.jianqing.interview.facebook.lc20;

import com.jianqing.interview.base.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * binary search tree 转double linkedlist
 * 转完 左 指向前， 右 指向后
 */
public class LC_426_ConvertBinarySearchTreeToSortedDoublyLinkedList {

    // 利用inorder traversal
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode pre = null;
        TreeNode head = null;
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (pre == null) {
                head = root;
            }
            else {
                pre.right = root;
                root.left = pre;
            }

            pre = root;
            root = root.right; // 转到右节点，如果右节点是null, 下轮循环就处理root
        }

        pre.right = head;
        head.left = pre;

        return head;
    }
}
