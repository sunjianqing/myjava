package com.jianqing.interview.facebook.lc20;

import com.jianqing.interview.base.TreeNode;

/**
 * BFS DFS 都可以， DFS有点tricky
 *
 * BFS
 * 就是按层遍历，如果碰见null node 之后， queue里还有数据， 那就不是complete binary tree
 * For a complete binary tree,
 * there should not be any node after we met an empty one.
 *
 * DFS
 * 算个total nodes count
 * 然后分别计算如果去到某层，那层节点的index，跟total count之间的关系
 * 就是root 是 index 1 ， 第二层两个节点index 是 2，3
 * 第三层是 4 ，5，6，7
 *
 * 如果5号节点不为空， 这时整个树只有4个节点, 这时就得return false
 *     1
 *    / \
 *   2  3
 *    \
 *     5
 *
 *
 */
public class LC_958_CheckCompletenessofaBinaryTree {

    public boolean isCompleteTreeBFS(TreeNode root) {
        int total = countNodes(root);
        return helper(root, 1, total);
    }

    public boolean isCompleteTreeDFS(TreeNode root) {
        int total = countNodes(root);
        return helper(root, 1, total);
    }

    private int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private boolean helper(TreeNode root, int idx, int total) {
        if (root == null) {
            return true;
        }
        if (idx > total) {
            return false;
        }
        return helper(root.left, idx * 2, total)
                && helper(root.right, idx * 2 + 1, total);
    }

}
