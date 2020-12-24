package com.jianqing.interview.facebook.lc20;

import com.jianqing.interview.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Binary Tree Right Side View
 *
 * 从右面看过去
 *
 * 按层遍历，往queue里加的时候， 先加右节点
 */
public class LC_199_BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        // reverse level traversal
        List<Integer> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        if (root == null) return result;

        queue.offer(root);
        while (queue.size() != 0) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode cur = queue.poll();
                if (i == 0) result.add(cur.val);
                if (cur.right != null) queue.offer(cur.right);
                if (cur.left != null) queue.offer(cur.left);
            }

        }
        return result;
    }
}
