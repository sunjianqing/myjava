package com.jianqing.interview.classic;

import java.util.*;

/**
 * Created by jianqing_sun on 1/12/18.
 *
 * 用BFS 染色
 */
class Vertex {
    final int val;
    List<Vertex> adjList = new ArrayList<>();

    public Vertex(int val) {
        this.val = val;
    }

}

class Graph {
    List<Vertex> vertices = new ArrayList<>();
}


public class Birpartite {
    // Detect Birpartite

    public static void main(String[] args) {
        Graph g = new Graph();
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        //Vertex v6 = new Vertex(6);

        v1.adjList.add(v2);
        v1.adjList.add(v3);

        v2.adjList.add(v1);
        v2.adjList.add(v4);

        v3.adjList.add(v1);
        v3.adjList.add(v4);
        v3.adjList.add(v5);

        v4.adjList.add(v2);
        v4.adjList.add(v3);
        v4.adjList.add(v5);

        v5.adjList.add(v3);
        v5.adjList.add(v4);

        g.vertices.add(v1);
        g.vertices.add(v2);
        g.vertices.add(v3);
        g.vertices.add(v4);
        g.vertices.add(v5);


        //g.vertices.add(v6);

        Birpartite b = new Birpartite();
        boolean birpartite = b.isBirpartite(g);
        System.out.println("Is birpartite " + birpartite);


    }

    public boolean isBirpartite(Graph g) {

        Vertex start = g.vertices.get(0);

        Queue<Vertex> queue = new LinkedList();
        queue.add(start);

        // 可变对象最好不要作为hash key
        Map<Vertex, Integer> colorMap = new HashMap<>();
        // 1-red, 2-blue
        colorMap.put(start, 1);
        // BFS
        while (!queue.isEmpty()) {
            Vertex cur = queue.poll();
            int curColor = colorMap.get(cur);
            if (cur.adjList != null) {
                for (Vertex v : cur.adjList) {

                    if(!colorMap.containsKey(v)){
                        // not visited
                        queue.add(v);
                        colorMap.put(v, curColor == 1 ? 2 : 1);
                        continue;
                    }

                    if(colorMap.get(v) == curColor) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
