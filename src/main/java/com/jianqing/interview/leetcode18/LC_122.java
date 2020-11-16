package com.jianqing.interview.leetcode18;

/**
 *  Best Time to Buy and Sell Stock II
 *
 *  就是找波峰 波谷， 然后加起来
 *
 *  或者说 ， 就是所有的上升坡度 加起来
 */
public class LC_122 {
    public int maxProfit(int[] prices) {
      if (prices == null || prices.length == 0) {
          return 0;
      }

      int profit = 0 ;
      for(int i = 1; i < prices.length; i++) {
          if(prices[i] > prices[i-1]) {
              profit += prices[i] - prices[i-1];
          }
      }

      return profit;
    }
}
