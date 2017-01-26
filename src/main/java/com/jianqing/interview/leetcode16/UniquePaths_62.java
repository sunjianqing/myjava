package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 1/6/17.
 */
public class UniquePaths_62 implements Solution {

    @Override
    public void solution() {

    }

    public int uniquePaths(int m, int n) {
        int[][] pathArr = new int[m][n];


        for (int i = 0; i < m; i++) {
            pathArr[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            pathArr[0][j] = 1;
        }

        if (m > 0 && n > 0) {
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    pathArr[i][j] = pathArr[i-1][j] + pathArr[i][j-1];
                }
            }
        }

        return pathArr[m - 1][n - 1];


    }
}
