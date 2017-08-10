package com.jianqing.interview.classic;

import com.jianqing.interview.base.TreeNode;

/**
 * Created by jianqingsun on 12/26/16.
 */
public class LCA  {

    public static TreeNode findLCA(TreeNode root, int val1, int val2){
        if(root == null) return null;

        //找到两个节点中的一个就返回
        if(root.val == val1 || root.val == val2){
            return root;
        }
        //分别在左右子树查找两个节点
        TreeNode left_lca = findLCA(root.left, val1, val2);
        TreeNode right_lca = findLCA(root.right, val1, val2);

        if(left_lca != null && right_lca != null){
            //此时说明，两个节点肯定是分别在左右子树中，当前节点比为LCA
            return root;
        }
        return left_lca != null ? left_lca : right_lca;
    }

    // 如果是BST
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return root;
        }
    }

}
