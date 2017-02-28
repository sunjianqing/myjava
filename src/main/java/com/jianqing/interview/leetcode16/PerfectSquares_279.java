package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 2/2/17.
 */
public class PerfectSquares_279 implements Solution {
    @Override
    public void solution() {

    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        if (n <= 0) {
            return 0;
        }

        dp[1] = 1;

        int i = 2;
        while (i <= n) {
            int min = i;
            for (int j = 1; j * j <= n; j++) {
                if (i - j * j >= 0 && dp[i - j * j] + 1 < min) {
                    min = dp[i - j * j] + 1;
                }
            }
            dp[i] = min;
            i++;    
        }

        return dp[n];

    }

}
