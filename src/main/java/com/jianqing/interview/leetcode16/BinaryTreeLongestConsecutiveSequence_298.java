package com.jianqing.interview.leetcode16;

import com.jianqing.interview.base.TreeNode;

/**
 * Created by jianqingsun on 7/26/17.
 * <p>
 * https://segmentfault.com/a/1190000003957798
 */
public class BinaryTreeLongestConsecutiveSequence_298 {

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return helper(root.val -1 , 0, root);
    }

    public int helper(int pre, int len, TreeNode node) {
        if(node == null)
            return len;


        int curlen = 0;
        if(node.val - 1 == pre){
            curlen = len + 1;
        }
        else {
            curlen = 1;
        }

        return Math.max(curlen, Math.max(helper(node.val, curlen, node.left), helper(node.val, curlen, node.right)));
    }
}
