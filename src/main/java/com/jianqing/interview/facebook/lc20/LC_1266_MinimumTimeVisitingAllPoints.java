package com.jianqing.interview.facebook.lc20;

/**
 * 观察发现两点间最小距离，就是 max(abs(x1-x2), abs(y1-y2))
 *
 */
public class LC_1266_MinimumTimeVisitingAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;

        if (points == null || points.length <= 1 || points[0].length <= 1)
            return res;

        for (int i = 1; i < points.length; i++) {
            res += Math.max(Math.abs(points[i][0] - points[i -1][0]), Math.abs(points[i][1] - points[i-1][1]));
        }

        return res;
    }
}
