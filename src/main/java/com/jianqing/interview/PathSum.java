package com.jianqing.interview;

import com.jianqing.interview.base.TreeNode;
import util.GenQueue;

/**
 * Created with IntelliJ IDEA.
 * User: jianqsun
 * Date: 11/12/13
 * Time: 4:51 PM
 * To change this template use File | Settings | File Templates.
 *
 *  Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 For example:
 Given the below binary tree and sum = 22,

     5
    / \
   4   8
  /   / \
 11  13  4
/  \      \
7  2      5

 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum {

    public GenQueue<TreeNode> queue = new GenQueue<TreeNode>();

    public TreeNode buildTree(){

        TreeNode tn = new TreeNode(5);
        TreeNode tn1 = new TreeNode(4);
        TreeNode tn2 = new TreeNode(8);
        TreeNode tn3 = new TreeNode(11);
        TreeNode tn4 = new TreeNode(13);
        TreeNode tn5 = new TreeNode(4);
        TreeNode tn6 = new TreeNode(7);
        TreeNode tn7 = new TreeNode(2);
        TreeNode tn8 = new TreeNode(5);

        tn.left = tn1;
        tn.right = tn2;
        tn1.left = tn3;
        tn2.left = tn4;
        tn2.right = tn5;
        tn3.left = tn6;
        tn3.right = tn7;
        tn5.right = tn8;

        return tn;
    }

    public  static  void main(String[] args){
       PathSum ps = new PathSum();
       TreeNode tn = ps.buildTree();
       int sum = 22;
       ps.solution(tn,22);

    }

    public void solution(TreeNode tn, int sum){
        queue.enqueue(tn);
        if(tn.left == null && tn.right == null){
            if(tn.val == sum ){
                if (queue.hasItems()){
                    queue.print();
                    System.out.println();
                }
            }
            return;
        }

        if(tn.left != null){
            solution(tn.left, sum - tn.val);
            queue.dequeueFromEntry();
        }
        if(tn.right != null)   {
            solution(tn.right, sum - tn.val);
            queue.dequeueFromEntry();
        }

    }
}
