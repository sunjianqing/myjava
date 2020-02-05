package com.jianqing.interview.leetcode18;

/**
 * Number of Dice Rolls With Target Sum
 * <p>
 * You have d dice, and each die has f faces numbered 1, 2, ..., f.
 * <p>
 * Return the number of possible ways (out of fd total ways) modulo 10^9 + 7 to roll the dice so the sum of the face up numbers equals target.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: d = 1, f = 6, target = 3
 * Output: 1
 * Explanation:
 * You throw one die with 6 faces.  There is only one way to get a sum of 3.
 * <p>
 * coin change 问题
 * 找总共多少种 ， 要scan 所有子问题
 * <p>
 * 对于每一个dice的可能值， 然后找剩下的dice 的 sum 减去当前值的所有可能
 */
public class lc_1155 {
    public int numRollsToTarget(int d, int f, int target) {

        int[][] dp = new int[d + 1][target + 1];
        int MOD = (int)Math.pow(10, 9) + 7;

        dp[0][0] = 1;

        for (int i = 1; i <= d; i++) {
            for(int j = 1; j <= target; j++) { // 所有 dp[i][0] = 0
                for(int k = 1; k <= f; k++) {
                    if( j >= k){
                        dp[i][j] = ( dp[i][j] + dp[i-1][j-k] ) % MOD;
                    }
                }
            }
        }

        return dp[d][target];
    }

}
