package com.jianqing.interview.leetcode16;

import com.jianqing.interview.base.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jianqingsun on 4/20/17.
 */
public class UniqueBinarySearchTreesII_95 {

    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }


    private List<TreeNode> helper(int start, int end) {
        if ( start > end ) {
            return Collections.emptyList();
        }

        List list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            TreeNode root = new TreeNode(i) ;

            List<TreeNode> leftTree = helper(start, i-1) ;
            List<TreeNode> rightTree = helper(i+1 , end );

            if(leftTree.isEmpty()) {
                root.left = null;
                if(rightTree.isEmpty()){
                    root.right = null;
                    // clone root
                    TreeNode newRoot  = new TreeNode(root.val);
                    newRoot.left = root.left;
                    newRoot.right = root.right;
                    list.add(newRoot);
                }
                else {
                    for ( TreeNode node : rightTree) {
                        root.right = node;
                        // clone root
                        TreeNode newRoot  = new TreeNode(root.val);
                        newRoot.left = root.left;
                        newRoot.right = root.right;
                        list.add(newRoot);
                    }
                }
            }
            else {
                // leftTree is not empty
                if(rightTree.isEmpty()){
                    root.right = null;
                    for ( TreeNode node : leftTree) {
                        root.left = node;
                        // clone root
                        TreeNode newRoot  = new TreeNode(root.val);
                        newRoot.left = root.left;
                        newRoot.right = root.right;
                        list.add(newRoot);
                    }
                }
                else{
                    for(TreeNode lnode : leftTree) {
                        for(TreeNode rnode : rightTree) {
                            root.left = lnode;
                            root.right = rnode;
                            // clone root
                            TreeNode newRoot  = new TreeNode(root.val);
                            newRoot.left = root.left;
                            newRoot.right = root.right;
                            list.add(newRoot);

                        }
                    }
                }
            }
        }

        return list;
    }

}


