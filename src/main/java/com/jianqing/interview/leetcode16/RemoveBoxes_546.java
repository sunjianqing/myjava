package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 3/5/18.
 *
 * https://leetcode.com/problems/remove-boxes/discuss/101310/Java-top-down-and-bottom-up-DP-solutions
 * http://www.cnblogs.com/grandyang/p/6850657.html
 *
 * dp[i][j][k] i 到 j 间 前面有个k个 color[i] 的最大值
 * 要求的就是 dp[0][n-1][0] 的最大值
 */
public class RemoveBoxes_546 {
    // Top down dp

    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return removeBoxesSub(boxes, 0, n - 1, 0, dp);
    }

    private int removeBoxesSub(int[] boxes, int i, int j, int k, int[][][] dp) {
        if (i > j) return 0;
        if (dp[i][j][k] > 0) return dp[i][j][k];

        for (; i + 1 <= j && boxes[i + 1] == boxes[i]; i++, k++); // optimization: all boxes of the same color counted continuously from the first box should be grouped together

        /*
         对于 这种情况 [... 1,2, ... 1,2...]
         现在i 在第一个1 处，不知道要把1连起来， 还是把2连起来取得最大值， 所以， 就得先算一步所有之前的 color 1 跟当年这个1 算一个point (k+1)*(k+1),
         然后再算从下个color 2开始 的情况（k = 0）
        */
        int res = (k + 1) * (k + 1) + removeBoxesSub(boxes, i + 1, j, 0, dp);

        /*
            当前color 可以match 之后的任意个同样的color， 在所有这些情况中， 求个最大值
            比如[... 1,2, ... 1,2...1..] 当前第一个color 1 后面还有两个， 每种拆分(拆在以后的1 处)都得算下
         */
        for (int m = i + 1; m <= j; m++) {
            if (boxes[i] == boxes[m]) {
                res = Math.max(res, removeBoxesSub(boxes, i + 1, m - 1, 0, dp) + removeBoxesSub(boxes, m, j, k + 1, dp));
            }
        }

        dp[i][j][k] = res;
        return res;
    }

}
