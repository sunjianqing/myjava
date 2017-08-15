package com.jianqing.interview.facebook;

import com.jianqing.interview.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianqing_sun on 8/9/17.
 */
public class BinaryTreePath_F {
    List<String> binaryTreePaths(TreeNode root) {

        if(root == null)
            return new ArrayList();

        List<String> res = new ArrayList<>();
        helper(root, res, root.val + "");

        return res;
    }

    private void helper(TreeNode root, List<String> res, String s) {

        if(root.left == null && root.right == null ){
            res.add(s);
            return;
        }

        if(root.left != null) {
            helper(root.left, res, s + "->" + root.left.val);
        }

        if(root.right != null) {
            helper(root.right, res, s + "->" + root.right.val);
        }

    }
}
