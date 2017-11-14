package com.jianqing.interview.leetcode17;

/**
 * Created by jianqingsun on 11/4/17.
 */
public class lc_718 {
    public int findLength(int[] A, int[] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return 0;
        }

        int max = 0;
        // 以 i， j 结尾的最长度
        int[][] dp = new int[A.length][B.length];


        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if(A[i] == B[j]){
                    if(i == 0 || j == 0)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = dp[i-1][j-1] + 1;

                    max = Math.max(dp[i][j], max);
                }
                else {
                    dp[i][j] = 0;
                }
            }
        }

        return max;
    }
}
