package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 8/3/17.
 *
 * dp(i, j) 代表从 从 (1,1) 原点 到 (i, j) 的sum
 * 所以， 求range 的sum ， 最大 减去两个小的， 再把重叠的加回来
 */
public class RangeSumQuery2D_304 {
    private int[][] dp;

    public RangeSumQuery2D_304(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m+1][n+1];

        for(int i = 1; i <= m; i++){
            for ( int j = 1; j <= n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int iMin = Math.min(row1, row2);
        int iMax = Math.max(row1, row2);

        int jMin = Math.min(col1, col2);
        int jMax = Math.max(col1, col2);

        return dp[iMax + 1][jMax + 1] - dp[iMax + 1][jMin] - dp[iMin][jMax + 1] + dp[iMin][jMin];
    }
}
