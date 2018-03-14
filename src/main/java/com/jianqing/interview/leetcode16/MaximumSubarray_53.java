package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 3/13/18.
 */
public class MaximumSubarray_53 {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        int max = nums[0];

        int cur = max;

        for(int i = 1; i < nums.length; i++){

            if(cur >= 0){
                cur += nums[i];
            }
            else{
                cur = nums[i];
            }

            max = Math.max(max, cur);
        }

        return max;
    }
}