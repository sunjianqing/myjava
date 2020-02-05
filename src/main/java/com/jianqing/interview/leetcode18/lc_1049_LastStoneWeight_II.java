package com.jianqing.interview.leetcode18;

/**
 *
 *
 *
 * We have a collection of rocks, each rock has a positive integer weight.
 *
 * Each turn, we choose any two rocks and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 *
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the smallest possible weight of this stone (the weight is 0 if there are no stones left.)
 *
 *
 *这个问题可以转化为 0-1 背包问题 的变种
 给一组数， 怎么分成two groups ， 使得它们的差值最小

 This question eaquals to partition an array into 2 subsets whose difference is minimal
 (1) S1 + S2  = S
 (2) S1 - S2 = diff

 ==> -> diff = S - 2 * S2  ==> minimize diff equals to  maximize S2

 要使diff 越小， S2 就越大， 越逼近S/2 。 到背包问题里， 就是尝试所有的背包组合 和 S2（0 - S/2）, 正好装到S2

 Now we should find the maximum of S2 , range from 0 to S / 2, using dp can solve this

 dp[i][j]   = {true if some subset from 1st to j'th has a sum equal to sum i, false otherwise}
 i ranges from (sum of all elements) {1..n}
 j ranges from  {1..n}

 */
public class lc_1049_LastStoneWeight_II {

    public int lastStoneWeightII(int[] stones) {
        int total = 0;

        for(int s : stones) {
            total += s;
        }

        int n = stones.length;
        int mid = total / 2;
        int s2 = 0;
        boolean[][] dp = new boolean[mid+1][n+1];

        for (int i = 0; i <= n; i++) {
            dp[0][i] = true;
        }

        for (int i = 1; i <= n; i++) {
            for(int s = 1; s <= mid; s++){
                if(dp[s][i-1] || ( s >= stones[i-1] && dp[s-stones[i-1]][i-1])) {
                    // 不包含当前元素，可以达到s， 或者是 包含当前元素且之前i-1个元素已经可以装到 s- stones[i-1]
                    dp[s][i] = true;
                    s2 = Math.max(s2, s); // 记录越来越大（或者说越来越逼近mid 的s2)

                }
            }
        }

        return total - 2 * s2;


    }
}
