package com.jianqing.interview.leetcode;

import java.util.List;

/**
 * Created by jianqing_sun on 4/6/17.
 * DP
 */
public class Triangle_120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int[][] dp = new int[triangle.size()][triangle.size()];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][0] + triangle.get(i).get(j);
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }
            }
        }

        // find the mininum from the last line
        int min = Integer.MAX_VALUE;
        for (int n = 0; n < triangle.size(); n++) {
            if (dp[triangle.size() - 1][n] < min) {
                min = dp[triangle.size() - 1][n];
            }
        }

        return min;
    }
}
