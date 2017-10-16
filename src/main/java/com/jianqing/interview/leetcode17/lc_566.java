package com.jianqing.interview.leetcode17;

/**
 * Created by jianqing_sun on 10/11/17.
 */
public class lc_566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (r * c > m * n)
            return nums;

        int[][] res = new int[r][c];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (index % c == 0) {
                    res[index / c] = new int[c];
                }

                res[index / c][index % c] = nums[i][j];
                index++;
            }
        }

        return res;
    }

}
