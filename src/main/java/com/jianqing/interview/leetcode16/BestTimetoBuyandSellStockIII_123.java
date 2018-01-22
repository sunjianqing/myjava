package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 1/13/18.
 * <p>
 * 在 i 处切开， 算 [0,i-1] 的最大值 p1 ， 再算个[i, n-1] 的最大值 p2， 最后再算所有max(p1+p2)
 */
public class BestTimetoBuyandSellStockIII_123 {

    // 基本思想是分成两个时间段，然后对于某一天，计算之前的最大值和之后的最大值
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int max = 0;
        // dp数组保存左边和右边的利润最大值
        int[] left = new int[prices.length];        // 计算[0,i]区间的最大值
        int[] right = new int[prices.length];   // 计算[i,len-1]区间的最大值

        process(prices, left, right);

        // O(n)找到最大值
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max, left[i] + right[i]);
        }

        return max;
    }

    public static void process(int[] prices, int[] left, int[] right) {
        left[0] = 0;
        int min = prices[0];        // 最低买入价

        // 左边递推公式
        for (int i = 1; i < left.length; i++) {
            left[i] = Math.max(left[i - 1], prices[i] - min);   // i的最大利润为（i-1的利润）和（当前卖出价和之前买入价之差）的较大那个
            min = Math.min(min, prices[i]);     // 更新最小买入价
        }

        right[right.length - 1] = 0;
        int max = prices[right.length - 1];       // 最高卖出价
        // 右边递推公式
        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], max - prices[i]); // i的最大利润为（i+1的利润）和（最高卖出价和当前买入价之差）的较大那个
            max = Math.max(max, prices[i]);     // 更新最高卖出价
        }

//      System.out.println(Arrays.toString(left));
//      System.out.println(Arrays.toString(right));
    }
}
