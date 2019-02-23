package com.jianqing.interview.classic;

import java.util.ArrayList;
import java.util.List;

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
