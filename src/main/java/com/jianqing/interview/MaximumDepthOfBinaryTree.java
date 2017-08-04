package com.jianqing.interview;

import com.jianqing.interview.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jianqsun on 4/21/14.
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root){
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        if(root == null){
            depth = 0;
        }
        else
        {
           queue.offer(root);
           queue.offer(null);

           while(!queue.isEmpty()){
               TreeNode node = queue.poll();
               if(node == null){
                   depth ++;
                   if(!queue.isEmpty()){
                       queue.offer(null); // add null to split the layer
                   }
               }
               else{
                    if(node != null && node.left != null)
                        queue.offer(node.left);

                    if(node != null && node.right != null)
                        queue.offer(node.right);
               }
           }
        }

        return depth;

    }
}
