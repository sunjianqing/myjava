package com.jianqing.interview.leetcode16;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jianqingsun on 3/8/17.
 */
public class PopulatingNextRightPointersinEachNode_116 {

    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<>();

        if (root != null) {
            queue.add(root);

            while (!queue.isEmpty()) {
                int size = queue.size();

                TreeLinkNode lastNode = null;
                for ( int i = 0 ; i < size; i++) {
                    TreeLinkNode node = queue.poll();
                    if ( node.left != null ){
                        queue.add(node.left);
                    }

                    if ( node.right != null ){
                        queue.add(node.right);
                    }
                    if( lastNode != null) {
                        lastNode.next = node;
                    }
                    lastNode = node;

                }
            }
        }
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}