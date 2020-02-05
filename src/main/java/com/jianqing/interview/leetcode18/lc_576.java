package com.jianqing.interview.leetcode18;

/**
 * 576 Out of Boundary Paths
 *
 * DP[i][j][k] stands for how many possible ways to walk into cell j,k in step i (most step i),
 * DP[i][j][k] only depends on DP[i - 1][j][k],
 * so we can compress 3 dimensional dp array to 2 dimensional.
 */
public class lc_576 {
    public int findPaths(int m, int n, int N, int i, int j) {
        return 0;
    }
}
