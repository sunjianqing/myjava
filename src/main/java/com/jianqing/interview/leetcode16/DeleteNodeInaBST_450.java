package com.jianqing.interview.leetcode16;

import com.jianqing.interview.leetcode.TreeNode;

/**
 * Created by jianqing_sun on 2/13/17.
 */
public class DeleteNodeInaBST_450 implements Solution {

    public static void main(String[] args) {
        DeleteNodeInaBST_450 d = new DeleteNodeInaBST_450();
        d.solution();
    }

    @Override
    public void solution() {
        TreeNode root = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        root.left = node3;
        root.right = node6;

        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);

        node3.left = node2;
        node3.right = node4;

        TreeNode node7 = new TreeNode(7);
        node6.right = node7;

        deleteNode(root, 3);

    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // key == root.val
            if (root.right != null) {
                root.val = findMin(root.right);
                // 在这个分支上， 删除上移的节点
                root.right = deleteNode(root.right, root.val);
            } else {
                root = root.left;
            }

        }

        return root;

    }

    public int findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        int val = root.val;
        return val;
    }

}
