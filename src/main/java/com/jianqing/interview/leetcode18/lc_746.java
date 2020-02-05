package com.jianqing.interview.leetcode18;

public class lc_746 {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }

        if (cost.length == 1) {
            return cost[0];
        }

        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }

        int n = cost.length;
        int[] dp = new int[n+1];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i <= n; i++) {
            int costV =  (i == n ) ? 0 : cost[i]; // i = n 的时候已经到顶了， cost 是0
            dp[i] = Math.min(dp[i - 1] + costV, dp[i - 2] + costV);
        }
        // [0,0,0,1]
        return dp[n];


    }

}
