package com.jianqing.interview.leetcode16;

import java.util.*;

/**
 * Created by jianqingsun on 6/12/17.
 */

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }
};

public class CloneGraph_133 {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        List<UndirectedGraphNode> nodes = getNodes(node);

        // copy nodes
        HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();

        for (UndirectedGraphNode n : nodes) {
            mapping.put(n, new UndirectedGraphNode(n.label));
        }

        // copy edges
        for (UndirectedGraphNode n : nodes) {
            UndirectedGraphNode newNode = mapping.get(n);
            for (UndirectedGraphNode neighbor : n.neighbors) {
                UndirectedGraphNode newNeighbor = mapping.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }

        return mapping.get(node);
    }

    private List<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();

        HashSet<UndirectedGraphNode> set = new HashSet<>();

        queue.offer(node);
        set.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            for (UndirectedGraphNode neighbor : head.neighbors) {
                if (set.contains(neighbor)) {
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        return new ArrayList<UndirectedGraphNode>(set);
    }

    public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Stack<UndirectedGraphNode> stack = new Stack<UndirectedGraphNode>();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);

        hm.put(node, head);
        stack.push(node);
        while (!stack.isEmpty()){
            UndirectedGraphNode curnode = stack.pop();
            for(UndirectedGraphNode neighbor: curnode.neighbors){
                if(!hm.containsKey(neighbor)){
                    stack.push(neighbor);
                    UndirectedGraphNode newNeighbor = new UndirectedGraphNode(neighbor.label);

                    hm.put(neighbor, newNeighbor);
                }


                // 把新点的neighbor build 起来
                hm.get(curnode).neighbors.add(hm.get(neighbor));
            }
        }

        return head;
    }

}
