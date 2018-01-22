package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 12/2/16.
 */
public class BestTimetoBuyandSellStock_121 implements Solution {
    @Override
    public void solution() {

    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int maxProfit = 0;
        int curMin = prices[0];

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < curMin)
                curMin = prices[i];

            maxProfit = Math.max(maxProfit, prices[i] - curMin);
        }

        return maxProfit;
    }
}
