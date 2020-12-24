package com.jianqing.interview.facebook.lc20;

/**
 * Subarray Sum Equals K
 *
 * Given an array of integers nums and an integer k,
 * return the total number of continuous subarrays whose sum equals to k.
 *
 *
 */
public class LC_560_SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int[] preSum = new int[nums.length + 1];

        if (nums == null || nums.length == 0) {
            return 0;
        }

        preSum[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i+1] = preSum[i] + nums[i];
        }

        int res = 0;
        for (int j = 0; j < nums.length; j++) {
            for (int m = 1; m <= nums.length - j; m++) {
                if(preSum[j+m] - preSum[j] == k) {
                    res++;
                }
            }
        }

        return res;
    }
}
