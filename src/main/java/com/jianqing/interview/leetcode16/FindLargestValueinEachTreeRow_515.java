package com.jianqing.interview.leetcode16;

import com.jianqing.interview.base.TreeNode;

import java.util.*;

/**
 * Created by jianqing_sun on 3/5/18.
 */
public class FindLargestValueinEachTreeRow_515 {
    public List<Integer> solution(TreeNode root){

        List<Integer> res = new ArrayList<>();

        if(root == null)
            return res;

        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        Queue<TreeNode> nq = new LinkedList<>();

        nq.add(root);
        while (!nq.isEmpty()){
            Queue<TreeNode> tmp = new LinkedList<>();

            while(!nq.isEmpty()){
                TreeNode node = nq.poll();
                q.add(node.val);
                if(node.left != null){
                    tmp.add(node.left);
                }

                if(node.right != null){
                    tmp.add(node.right);
                }
            }
            res.add(q.peek());
            q.clear();

            nq = tmp;
        }

        return res;

    }
}
