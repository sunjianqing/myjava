package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 7/15/17.
 * <p>
 * 第i个房子刷的漆的最小的cost
 * <p>
 * 相当于在 所有的 cost[i][j] 里找 cost[i][j] + (i - 1)个房子的最小值， 或者次小值
 * http://www.learn4master.com/interview-questions/leetcode/leetcode-paint-house-ii-solution-java
 *
 */
public class PaintHouseII_265 {

    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0)
            return 0;

        int preMin = 0;
        int preSecond = 0;
        int preIndex = -1;

        for (int i = 0; i < costs.length; i++) {
            int currMin = Integer.MAX_VALUE;
            int currSecond = Integer.MAX_VALUE;
            int currIndex = 0;

            //  这个循环过后， cost[i][j] 就是记录了之前的最小值的 加上了 当前 每个颜色j 的cost， 最小和 次小 保存在两个变量里， 最小的index 也保存了
            for (int j = 0; j < costs[0].length; j++) {
                if (preIndex == j) {
                    costs[i][j] += preSecond;
                } else {
                    costs[i][j] += preMin;
                }

                if (currMin > costs[i][j]) {
                    currSecond = currMin;
                    currMin = costs[i][j];
                    currIndex = j;
                } else if (currSecond > costs[i][j]) {
                    currSecond = costs[i][j];
                }
            }

            preMin = currMin;
            preSecond = currSecond;
            preIndex = currIndex;
        }

        // loop 最后一行， 找最小的那个值
        int result = Integer.MAX_VALUE;
        for (int j = 0; j < costs[0].length; j++) {
            if (result > costs[costs.length - 1][j]) {
                result = costs[costs.length - 1][j];
            }
        }
        return result;
    }
}
