package com.jianqing.interview.leetcode16;

import com.jianqing.interview.base.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by jianqingsun on 11/10/16.
 */
public class MaxDepthOfBinaryTree implements Solution {

    @Override
    public void solution() {

    }

    public int maxDepth3(TreeNode root) {
        if (root == null)
            return 0;

        int left = root.left == null ? 0 : 1 + maxDepth(root.left);
        int right = root.right == null ? 0 : 1 + maxDepth(root.right);
        return Math.max(left, right);
    }


    public int maxDepth(TreeNode root) {
        if ( root == null )
            return 0;

        Deque<TreeNode> queue = new ArrayDeque();
        queue.addFirst(root);
        int depth = 0;
        while(!queue.isEmpty()){
            depth++;
            List<TreeNode> elements = new ArrayList<>();
            while(queue.iterator().hasNext()){
                TreeNode node = queue.removeFirst();
                if(node.left != null)
                    elements.add(node.left);
                if(node.right != null)
                    elements.add(node.right);
            }
            if(!elements.isEmpty())
                queue.addAll(elements);

        }

        return depth;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

}
