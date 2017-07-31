package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 7/13/17.
 *
 *
 * http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html
 *
 * 用stack 保存递增的bar， 发现第一个递减的bar （i） 的时候开始出栈， 每次出栈都要计算下跨越的面积， 知道发现第一个比i 小的bar ， 这时连同i计算下当前跨度下的面积。
 * 然后， 接着找递增的bar 进栈
 */
public class LargestRectangleInHistogram_84 {
}
