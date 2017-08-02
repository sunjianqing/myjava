package com.jianqing.interview.leetcode16;

import com.jianqing.interview.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jianqing_sun on 2/20/17.
 */
public class SymmetricTree_101 {

    public static void main(String[] args) {

    }

    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }


    public boolean isSymmetric3(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
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
