package com.jianqing.interview.leetcode18;

public class LC_123 {

    public static void main(String[] args) {
        LC_123 lc = new LC_123();
        lc.maxProfit(new int[]{3,3,5,0,0,3,1,4});
    }
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;

        int[] left = new int[len];  // 从左到右扫， 记录到 i 为止， 卖出的最高profit可能值 （不停的拿当前价格， 去减最小卖入价）
        int[] right = new int[len]; // 从右到左扫， 记录从 i 到最后，在i点之后买入的，以后卖出的最高可能值 （不停的拿最大价格， 减当前值）

        left[0] = 0;
        int profit = 0;
        int lowest = prices[0];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(profit, prices[i] - lowest);
            profit = Math.max(profit, left[i]);
            lowest = Math.min(lowest, prices[i]);
        }

        int highest = prices[len-1];
        right[len-1] = 0;
        profit = 0;
        for (int i = len-2; i >= 0; i--) {
            right[i] = Math.max(profit, highest - prices[i]);
            profit = Math.max(profit, right[i]);
            highest = Math.max(highest, prices[i]);
        }

        int res = 0;

        for (int i = 0; i < len; i++) {
            res =  Math.max(res, left[i] + right[i]);
        }

        return res;



    }


}
