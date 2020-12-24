package com.jianqing.interview.basic.graph;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS
 *
 * 可以解决无权图的最短路径
 *
 * 普通的BFS算法，无法解决有权图中的最短路径问题，因为它不能保证处于队列前面的顶点是最接近源s的顶点
 *
 * Dijsktra 单元最短
 *
 * Floyd (Floyd–Warshall) 全源最短路径
 */
public class ShortestPath {

    // Suppose graph is connected
    public int bfs (UnWeightedGraph graph, int src, int dst) {

        int[] path = new int[graph.vertices]; // 用于记录parent 节点
        boolean visited[] = new boolean[graph.vertices];

        Queue<Integer> queue = new LinkedList<>();

        queue.add(src);
        visited[src] = true;

        // destination 数组，记录到从src 到当前顶点的距离
        int[] dist = new int[graph.vertices];
        dist[src] = 0;
        while (queue.isEmpty()) {
            int cur = queue.poll();
            if (!graph.adjList.get(cur).isEmpty()) {
                for (int node : graph.adjList.get(cur)) {
                    if (visited[node] == false) {
                        dist[node] = dist[cur] + 1;
                        queue.add(node);
                        path[node] = cur;

                        if (node == dst) {
                            return dist[dst];
                        }
                    }
                }
            }
        }

        return -1;
    }
}
