package com.jianqing.interview.leetcode17;

import java.util.Arrays;

/**
 * Created by jianqing_sun on 10/9/17.
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 * <p>
 * Example 1:
 * Input: [1,4,3,2]
 * <p>
 * Output: 4
 * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 */
public class lc_561 {

    public int arrayPairSum(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        Arrays.sort(nums);
        int minSum = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            minSum += nums[i];
        }

        return minSum;
    }
}
