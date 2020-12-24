package com.jianqing.interview.facebook.lc20;

import com.jianqing.interview.base.TreeNode;

import java.util.*;

public class LC_987_VerticalOrderTraversalofaBinaryTree {

    private class NodeColPair{
        TreeNode node;
        int col;

        public NodeColPair(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) return null;

        List<List<Integer>> res = new ArrayList<>();

        Map<Integer, List<Integer>> vmap = new HashMap<>();
        Queue<NodeColPair> queue = new ArrayDeque<>();

        queue.add(new NodeColPair(root, 0));

        while (!queue.isEmpty()) {
            int qsize = queue.size();
            for (int i = 0; i < qsize; i++) {
                NodeColPair ncPair = queue.poll();

                List<Integer> colValList = vmap.getOrDefault(ncPair.col, new ArrayList<>());
                colValList.add(ncPair.node.val);
                vmap.put(ncPair.col, colValList);

                if (ncPair.node.left != null) {
                    queue.add(new NodeColPair(ncPair.node.left, ncPair.col - 1));
                }
                if (ncPair.node.right != null) {
                    queue.add(new NodeColPair(ncPair.node.right, ncPair.col + 1));
                }
            }
        }

        Integer[] a = new Integer[vmap.keySet().size()];
        vmap.keySet().toArray(a);
        Arrays.sort(a);

        for (Integer colNum : a) {
            Collections.sort(vmap.get(colNum));
            res.add(vmap.get(colNum));
        }

        return res;
    }
}
