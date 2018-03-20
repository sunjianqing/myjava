package com.jianqing.interview.leetcode16;

import com.jianqing.interview.base.TreeNode;

/**
 * Created by jianqing_sun on 3/5/18.
 *
 * Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.

 Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

 If no such second minimum value exists, output -1 instead.

 Example 1:
 Input:
      2
     / \
    2   5
       / \
      5  7

 Output: 5
 Explanation: The smallest value is 2, the second smallest value is 5.
 Example 2:
 Input:
     2
    / \
   2  2

 Output: -1
 Explanation: The smallest value is 2, but there isn't any second smallest value.



 */
public class SecondMinimumNodeInaBinaryTree_671 {
    public int findSecondMinimumValue(TreeNode root) {

        if (root == null) {
            return -1;
        }

        if (root.left == null && root.right == null) {
            return -1;
        }

        int l = -1;
        if (root.left != null) {
            if (root.left.val == root.val) {
                l = findSecondMinimumValue(root.left);
            } else {
                // 根据题目， 此处一定是root.left.val 大
                l = root.left.val;
            }
        }

        int r = -1;
        if (root.right != null) {
            if (root.right.val == root.val) {
                r = findSecondMinimumValue(root.right);
            } else {
                // 根据题目， 此处一定是root.right.val 大
                r = root.right.val;
            }
        }

        if (r != -1 && l != -1)
            return Math.min(l, r);

        return l == -1 ? r : l;

    }


}
