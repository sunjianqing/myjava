package com.jianqing.interview.facebook;

/**
 * Created by jianqingsun on 8/2/17.
 */
public class BuyStock {

    public int StockI(int[] prices) {
        int profit = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);

            profit = Math.max(profit, prices[i] - min);
        }

        return profit;
    }

    public int StockII(int[] prices) {
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if(prices[i] - prices[i-1] > 0 ){
                profit += prices[i] - prices[i-1];
            }
        }

        return profit;
    }
}
