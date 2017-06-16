package com.jianqing.interview.facebook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by jianqing_sun on 6/13/17.
 */
class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class KCloestPoints {
    public static void main(String[] args) {
        KCloestPoints kp = new KCloestPoints();
        List<Point> points = new ArrayList<>();
        points.add(new Point(1,1));
        points.add(new Point(1,2));
        points.add(new Point(1,3));
        points.add(new Point(2,2));
        points.add(new Point(3,1));
        points.add(new Point(5,1));
        points.add(new Point(2,1));

        int k = 7;
        List<Point> points1 = kp.kClosestPoints(points, k);
        int index = 1;
        for(Point p : points1){
            if(index++ <= k)
                System.out.println("Point " + p.x + " " + p.y);
        }

    }

    public List<Point> kClosestPoints(List<Point> points, int k) {
        List<Point> res = new ArrayList<Point>();

        if (points == null || points.size() == 0) {
            return res;
        }

        PriorityQueue queue = new PriorityQueue(k, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int res = (o1.x * o1.x + o1.y * o1.y - (o2.x * o2.x + o2.y * o2.y));

                if(res == 0)
                    return 0;

                if(res > 0)
                    return 1;
                else
                    return -1;

            }
        });

        for(Point p: points){
            queue.add(p);
        }

        while(!queue.isEmpty()){
            res.add((Point) queue.poll());
        }

        return res;
    }
}
