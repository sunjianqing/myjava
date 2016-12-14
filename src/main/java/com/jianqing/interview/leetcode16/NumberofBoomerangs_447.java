package com.jianqing.interview.leetcode16;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jianqingsun on 11/30/16.
 */
public class NumberofBoomerangs_447 implements Solution {
    @Override
    public void solution() {
//        int[][] points = {
//                {0, 0},{0, 1},{1, 2}
//        };
        int[][] points = new int[5][2];

        points[0] = new int[]{0, 0};
        points[1] = new int[]{0, 1};
        points[2] = new int[]{1, 2};

    }

    // points is 2 dimension [n][2] array
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j)
                    continue;

                int dist = computeDist(points[i], points[j]);

                /*
                  记录各个与当前point的距离
                 */
                if (map.containsKey(dist)) {
                    int val = map.get(dist) + 1;
                    map.put(dist, val);
                } else
                    map.put(dist, 1);
            }

            /*
                相当于从与当前point等距离的集合中，随意取两个的排列数 n * (n -1)
             */
            for (Integer val : map.values()) {
                result += val * (val - 1);
            }

            map.clear();

        }

        return result;

    }

    // point1 , 2 都是二维数组， 第一维 是 x 坐标， 第二维 是y 坐标
    private int computeDist(int[] point1, int[] point2) {
        int x = point1[0] - point2[0];
        int y = point1[1] - point2[1];

        return x * x + y * y; // 以这个代表距离， 不用开根号

    }
}
