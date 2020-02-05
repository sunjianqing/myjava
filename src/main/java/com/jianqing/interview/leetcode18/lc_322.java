package com.jianqing.interview.leetcode18;

import java.util.Arrays;

public class lc_322 {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0)
            return -1;

        int n = amount;

        int[] dp = new int[n+1];
        Arrays.fill(dp, amount + 1); // 找一最大值作为初始值
        dp[0] = 0;

        for( int i = 1; i <= amount; i++) {
            for(int j = 0; j < coins.length; j++){
                if(coins[j] > i) continue;

                dp[i] = Math.min(dp[i-coins[j]] + 1, dp[i]);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
