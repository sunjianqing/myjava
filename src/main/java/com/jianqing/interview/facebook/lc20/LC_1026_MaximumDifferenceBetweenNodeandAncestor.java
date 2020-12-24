package com.jianqing.interview.facebook.lc20;

import com.jianqing.interview.base.TreeNode;

/**
 * 从root 到 leaf 节点的路径上任意两个，一定存在ancestor 关系，
 * DFS 一路下去， maintain 一个 路径最大跟最小值
 *
 */
public class LC_1026_MaximumDifferenceBetweenNodeandAncestor {
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    public int dfs(TreeNode root, int mn, int mx) {
        if (root == null) return mx - mn;
        mx = Math.max(mx, root.val);
        mn = Math.min(mn, root.val);
        return Math.max(dfs(root.left, mn, mx), dfs(root.right, mn, mx));
    }
}
