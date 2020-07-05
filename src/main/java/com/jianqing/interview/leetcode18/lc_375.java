package com.jianqing.interview.leetcode18;

public class lc_375 {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1]; // memorization

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        helper(1, n, dp);

        return dp[1][n];

    }

    int helper(int i, int j, int[][] dp) {

        if (i == j) {
            dp[i][j] = 0;
            return 0;
        }

        if (dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }


        for (int k = i; k <= j; k++) {
            dp[i][j] = Math.min(dp[i][j], k + Math.max(k - 1 < i ? 0 : helper(i, k - 1, dp), k + 1 > j ? 0 : helper(k + 1, j, dp)));
        }

        return dp[i][j];

    }


}
