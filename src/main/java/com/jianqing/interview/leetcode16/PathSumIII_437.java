package com.jianqing.interview.leetcode16;

import com.jianqing.interview.leetcode.TreeNode;

/**
 * Created by jianqing_sun on 12/2/16.
 */
public class PathSumIII_437 implements Solution {
    @Override
    public void solution() {

    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;

        // do the recursive call on left, right subtree and call helper on root
        return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int findPath(TreeNode node, int sum){
        int res = 0;
        if (node == null)
            return 0;
        if (node.val == sum)
            res++;

        res += findPath(node.left, sum - node.val);
        res += findPath(node.right, sum - node.val);

        return res;
    }


}
