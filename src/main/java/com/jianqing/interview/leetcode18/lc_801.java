package com.jianqing.interview.leetcode18;

/**
 * Minimum Swaps To Make Sequences Increasing
 *
 * DP
 *
 * 需要maintain 两个数组， 一个是
 * keep[i] 表示 对于 A， B 在第 i 个元素位置上 不交换， 能满足单调递增的 operation 的次数
 * swap[i] 表示 对于 A， B 在第 i 个元素位置上 交换， 能满足单调递增的 operation 的次数
 *
 * 然后因为问题永远有解， 就把所有的 的在 i 位置的大小情况 分为三种
 * We define areBothSelfIncreasing: A[i - 1] < A[i] && B[i - 1] < B[i], areInterchangeIncreasing: A[i - 1] < B[i] && B[i - 1] < A[i].
 *
 * if areBothSelfIncreasing && areInterchangeIncreasing
 * 	        // Doesn't matter whether the previous is swapped or not.
 * 	        state(i, 0) = Math.min(state(i - 1, 0), state(i - 1, 1));
 * 	        state(i, 1) = Math.min(state(i - 1, 0), state(i - 1, 1)) + 1;
 * 	else if areBothSelfIncreasing
 * 	        // Following the previous action.
 * 	        state(i, 0) =  state(i - 1, 0);
 * 	        state(i, 1) =  state(i - 1, 1) + 1;
 * 	else if areInterchangeIncreasing
 *          // Opposite to the previous action.
 * 	        state(i, 0) = state(i - 1, 1);
 * 	        state(i, 1) = state(i - 1, 0) + 1;
 *
 * state 是个二维数组
 * state(i, 0) 就是keep[i]
 * state(i, 1) 就是swap[i]
 *  *
 *
 */
public class lc_801 {
}
