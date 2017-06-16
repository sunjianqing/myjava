package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 5/23/17.
 *
 * https://segmentfault.com/a/1190000007297715
 *
 */
public class BurstBallons_312 {
    public int maxCoins(int[] nums) {
        int len = nums.length;

        int[] ns = new int[ len + 2];

        for(int i = 0; i < len; i++) {
            ns[i+1] = nums[i];
        }

        ns[0] = 1;
        ns[len + 1] = 1;
        // dp[i][j]表示从i到j这个window范围内，能组成的最大值
        int[][] dp = new int[len+2][len+2];

        for(int k = 2; k < len + 2 ; k++){
            for( int left = 0; left < len + 2 - k; left++){
                // window[left, right] ， 不包含边界
                int right = left + k;
                for ( int i = left + 1; i < right; i++){
                    // 假设最后一个破的是i ， left ， right 一直保留
                    dp[left][right] = Math.max(dp[left][right], ns[left]*ns[i]*ns[right] + dp[left][i] + dp[i][right]);
                    // 当前项 是 ns[left]*ns[i]*ns[right] 不是  ns[i-1]*ns[i]*ns[i+1]

                }
            }
        }


        return dp[0][len+1];
    }
}
