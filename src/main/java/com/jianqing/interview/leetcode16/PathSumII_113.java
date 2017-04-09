package com.jianqing.interview.leetcode16;

import com.jianqing.interview.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianqingsun on 3/21/17.
 */
public class PathSumII_113 {

    public static void main(String[] args) {
        PathSumII_113 p = new PathSumII_113();
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(8);
        TreeNode treeNode4 = new TreeNode(11);
        TreeNode treeNode5 = new TreeNode(13);
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(2);
        TreeNode treeNode9 = new TreeNode(5);
        TreeNode treeNode10 = new TreeNode(1);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode6;

        treeNode4.left = treeNode7;
        treeNode4.right = treeNode8;

        treeNode6.left = treeNode9;
        treeNode6.right = treeNode10;

        p.pathSum(treeNode1, 22);


    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if ( root == null )
            return res;
        ArrayList<Integer> list = new ArrayList<>();

        helper(res, list, root, sum);

        return res;
    }

    public void helper(List<List<Integer>> res, ArrayList<Integer> list, TreeNode node, int sum) {

        if (node == null)
            return;

        sum -= node.val;

        if (node.right == null && node.left == null) {
            if (sum == 0) {
                list.add(node.val);
                List<Integer> newList = new ArrayList<Integer>(list);
                res.add(newList);
                list.remove(list.size()-1);
            }

            return;
        }

        list.add(node.val);
        helper(res, list, node.left, sum);
        helper(res, list, node.right, sum);
        list.remove(list.size() - 1);

    }
}
