package com.jianqing.interview.leetcode18;

/**
 * Best Time to Buy and Sell Stock
 */
public class LC_121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int res = 0;
        int minSoFar = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > minSoFar) {
                res = Math.max(res, prices[i] - minSoFar);
            }
            else {
                minSoFar = prices[i];
            }
        }

        return res;
    }
}
