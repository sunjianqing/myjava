package com.jianqing.interview.leetcode18;

public class lc_931 {
    /*
    dp[i][j] 在path 上， 可以构成的最小值
    dp[i][j] = min(dp[i-1][j-1], dp[i-1][j],dp[i-1][j+1]) + a[i][j]
     */
    public int minFallingPathSum(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return Integer.MIN_VALUE;
        }

        int m = A.length, n = A[0].length;
        int[][] dp = new int[m][n];

        // Init
        for(int i = 1; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = A[0][j];
        }

        for(int i = 1; i < m; i++) {
            for(int j = 0; j < n; j++) {

                // try left, current, right column
                if(j-1 >= 0){
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + A[i][j]);
                }

                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + A[i][j]);

                if(j+1 < n){
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j+1] + A[i][j]);
                }

            }
        }

        // find the minimum from the last row
        // 下面可以写成 Arrays.stream(dp[m- 1]).min().getAsInt();

        int res = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++) {
            res = Math.min(dp[m-1][j], res);
        }

        return res;

    }
}
