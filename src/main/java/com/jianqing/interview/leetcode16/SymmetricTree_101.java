package com.jianqing.interview.leetcode16;

import util.TreeNode;

import java.util.LinkedList;

/**
 * Created by jianqing_sun on 2/20/17.
 */
public class SymmetricTree_101 {

    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if( root == null )
            return true;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            LinkedList<TreeNode> tmpQueue = new LinkedList<>();

            int start = 0;
            int end = queue.size()-1;
            while ( start  < end  ){
                TreeNode startNode = queue.get(start);
                TreeNode endNode = queue.get(end);
                start ++ ;
                end --;
                if ( startNode == null && endNode == null ) {
                    continue;
                }
                else if ( startNode == null || endNode == null)
                    return false;

                if(startNode.val == endNode.val)
                    continue;
                else
                    return false;
            }

            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(node != null) {
                    tmpQueue.add(node.left);
                    tmpQueue.add(node.right);
                }
            }

            if ( !tmpQueue.isEmpty()) {
                queue = tmpQueue;
            }

        }
        return true;

    }
}
