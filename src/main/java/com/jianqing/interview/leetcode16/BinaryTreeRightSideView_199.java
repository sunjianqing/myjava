package com.jianqing.interview.leetcode16;

import com.jianqing.interview.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by jianqingsun on 1/10/17.
 */
public class BinaryTreeRightSideView_199 implements Solution {
    @Override
    public void solution() {

    }

    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();


        if (root != null) {
            queue.add(root);
            while (!queue.isEmpty()) {
                res.add(queue.peek().val);

                Queue<TreeNode> tmpQueue = new LinkedList<>();

                while (!queue.isEmpty()) {
                    TreeNode node = queue.remove();
                    if (node.right != null) {
                        tmpQueue.add(node.right);
                    }
                    if (node.left != null) {
                        tmpQueue.add(node.left);
                    }

                }
                if (!tmpQueue.isEmpty())
                    queue = tmpQueue;

            }
        }

        return res;
    }
}
