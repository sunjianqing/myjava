package com.jianqing.interview.leetcode18;

/**
 * Dice Roll Simulation
 * <p>
 * 给n 个dice ， 每个数字可能的连续出现次数不允许超过rollMax 的限制， 比如下面的， 不允许有 连续的两个1 跟 2
 * Input: n = 2, rollMax = [1,1,2,2,2,3]
 */
public class lc_1223 {
    private static final int MOD = 1000000007;

    /**
     * dp(i)(j)(k) 代表i 个dice， 以数字 j 结尾， 并且结尾时有k 个j
     * 填充dp 的时候 loop k 从 1 到 rollMax[j+1] - 1
     * dp(i)(j)(k) = dp(i-1)(j)( k-1)
     *
     * 再把 不等于 j 的 所有的  dp[x][j][1]  算了
     *      dp[x][j][1] =  sum dp[x-1][i][k] (k 从 1 到 rollMax[i-1]) 这一步 就是隔一个不等于当年数的数字，
     *      看看有多少种可能
     */

    /**
     * @param n
     * @param rollMax
     * @return
     */
    public int dieSimulator(int n, int[] rollMax) {
        if (n == 0) return 0;
        int[][][] dp = new int[n + 1][7][16];
        // initialization
        for (int i = 1; i <= 6; ++i) {
            if (rollMax[i - 1] > 0) {
                dp[1][i][1] = 1;
            }
        }
        for (int x = 2; x <= n; ++x) {
            for (int i = 1; i <= 6; ++i) {
                // if continue to add tail i, make sure consective num of i would less than or equal to rollMax[i-1]
                for (int k = 1; k < rollMax[i - 1]; ++k) {
                    dp[x][i][k + 1] = (dp[x][i][k + 1] + dp[x - 1][i][k]) % MOD;
                }
                // if add new tail j that differs from i, so we should jump out i
                for (int j = 1; j <= 6; ++j) {
                    if (j == i) continue;
                    for (int k = 1; k <= rollMax[i - 1]; ++k) {
                        dp[x][j][1] = (dp[x][j][1] + dp[x - 1][i][k]) % MOD;
                    }
                }
            }
        }
        int num = 0;
        for (int i = 1; i <= 6; ++i) {
            for (int k = 1; k <= 15; ++k) {
                num = (num + dp[n][i][k]) % MOD;
            }
        }
        return num;
    }


    // DFS + Memorization
    int[][][] dp = new int[5000][6][16];
    final int M = 1000000007;

    public int solution2(int n, int[] rollMax) {
        return dfs(n, rollMax, -1, 0);
    }

    private int dfs(int dieLeft, int[] rollMax, int last, int curlen) {
        if (dieLeft == 0) return 1;
        if (last >= 0 && dp[dieLeft][last][curlen] > 0) return dp[dieLeft][last][curlen];
        int ans = 0;
        for (int i = 0; i < 6; i++) {
            if (i == last && curlen == rollMax[i]) continue;
            ans = (ans + dfs(dieLeft - 1, rollMax, i, i == last ? curlen + 1 : 1)) % M;
        }
        if (last >= 0) dp[dieLeft][last][curlen] = ans;
        return ans;
    }
}
