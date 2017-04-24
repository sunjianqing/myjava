package com.jianqing.interview.leetcode16;


import com.jianqing.interview.base.TreeNode;

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

        if (root == null)
            return res;
        ArrayList<Integer> list = new ArrayList<>();

        helper(res, list, root, sum);

        return res;
    }

    public void helper(List<List<Integer>> res, ArrayList<Integer> solution, TreeNode root, int sum) {

        if (root == null)
            return;

        sum -= root.val;
        solution.add(root.val);
        if (root.right == null && root.left == null) {
            if (sum == 0) {
                res.add(new ArrayList<Integer>(solution));
            }
        } else {
            helper(res, solution, root.left, sum);
            helper(res, solution, root.right, sum);
        }
        solution.remove(solution.size() - 1);
    }


    public List<ArrayList<Integer>> pathSum2(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return result;

        ArrayList<Integer> l = new ArrayList<Integer>();
        l.add(root.val);
        dfs(root, sum - root.val, result, l);
        return result;
    }

    public void dfs(TreeNode t, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> l) {
        if (t.left == null && t.right == null && sum == 0) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.addAll(l);
            result.add(temp);
        }

        //search path of left node
        if (t.left != null) {
            l.add(t.left.val);
            dfs(t.left, sum - t.left.val, result, l);
            l.remove(l.size() - 1);
        }

        //search path of right node
        if (t.right != null) {
            l.add(t.right.val);
            dfs(t.right, sum - t.right.val, result, l);
            l.remove(l.size() - 1);
        }
    }


}
