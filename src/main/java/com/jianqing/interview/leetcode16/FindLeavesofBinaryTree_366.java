package com.jianqing.interview.leetcode16;

import com.jianqing.interview.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianqingsun on 2/13/18.
 * <p>
 * Find Leaves of Binary Tree
 * <p>
 * 每个节点根据左右子树的深度确定自己的深度值， 就是左右子树深度较大的那个+1，因为剥开的时候， 深度较浅的那个子树先变成null， 深度较深的那颗树不是
 * null。 这样根据节点的index， 就能找到相应的结果集
 *
 * https://www.youtube.com/watch?v=qJOHOKMnHdM
 */
public class FindLeavesofBinaryTree_366 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root);

        return res;
    }

    public int helper(List<List<Integer>> res, TreeNode root) {
        if (root == null) {
            return -1;
        }

        int left = helper(res, root.left);
        int right = helper(res, root.right);

        int cur = Math.max(left, right) + 1;

        // 这句不是太好理解， 就是通过跟踪递归可以发现，他的index都是连续的，没有跳跃写的情况，一般是这样：先0，再1，再2，再0，再1，再2，再3；
        // 不会出现先0，再2，再1，再4这样的情况. 处理左子树的时候， index 都是连续的， 再处理右子树时， 相应的cur可能已经在左子树的时候create 过了
        // 如果右子树index 还大， 就create 新的List 到结果集里
        if (res.size() == cur) {
            res.add(new ArrayList<>());
        }

        res.get(cur).add(root.val);

        root.left = null;
        root.right = null;
        return cur;
    }
}