package com.jianqing.interview.basic.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WeightedGraph {
    // adjacency list node
    static class AdjListNode {
        int label, weight;
        AdjListNode(int label, int weight)  {
            this.label = label;
            this.weight = weight;
        }
    };

    // index is the node label, we could use Map<Object, List<AdjListNode>> also
    List<List<AdjListNode>> adjList;

    public WeightedGraph(int numOfVertices) {
        adjList = new ArrayList<>(numOfVertices);
        for (int i = 0; i < numOfVertices; i++) {
            adjList.add(i, new ArrayList<AdjListNode>());
        }
    }

    public void addEdge(int src, int dst, int weight) {
        // we might need check whether or not node exists
        adjList.get(src).add(new AdjListNode(dst, weight)); // if it's undirected, we need add both direction edges
    }
}
