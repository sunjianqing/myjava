package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 1/3/17.
 * Unique Binary Search Trees
 *
 */
public class UniqueBinarySearchTrees_96 implements Solution {
    @Override
    public void solution() {

    }

    /*
        一维动态规划
        对于n = 4
        cnt = C0*C3 + C1*C2 + C2*C1 + C3*C0
        第一个乘数是左子树可能的情况， 第二个是右子树的情况
        cnt = 1作为root的情况 + 2作为root的情况 + 3作为root的情况 + 4作为root的情况

        递推公式G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0)
     */
    public int numTrees(int n) {
        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n ; i++ ){
            for(int j = 1; j<=i ; j++){
                dp[i] += dp[j-1] * dp[i-j];
            }
        }

        return dp[n];
    }
}
