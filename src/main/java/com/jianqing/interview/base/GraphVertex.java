package com.jianqing.interview.base;

import java.util.ArrayList;

/**
 * Created by jianqing_sun on 4/4/17.
 */
public class GraphVertex implements Comparable<GraphVertex> {
    String label;
    ArrayList<GraphVertex> vertices;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ArrayList<GraphVertex> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<GraphVertex> vertices) {
        this.vertices = vertices;
    }

    @Override
    public int compareTo(GraphVertex o) {
        return label.compareTo(o.getLabel());
    }
}
