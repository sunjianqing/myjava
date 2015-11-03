package com.jianqing.interview.leetcode;

/**
 * Created by jianqsun on 8/8/14.
 */
public class SumRootToLeaf {
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return root.val;

        return compute(root, root.val) ;
    }

    public int compute(TreeNode node, int val){
        int sum;
        if(node.left == null && node.right == null)
            sum = val;
        else{
            int l,r;
            if(node.left == null)
                l = 0;
            else
                l = compute(node.left, 10*val+node.left.val);

            if(node.right == null)
                r= 0;
            else
                r = compute(node.right, 10*val+node.right.val)   ;

            sum = l+r;

        }

        return sum;



    }
}
