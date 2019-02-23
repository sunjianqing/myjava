package com.jianqing.interview.leetcode18;

/**
 * Range Sum Query - Immutable
 */
public class lc_303 {

    int[] preSum;

    public lc_303(int[] nums) {
        preSum = new int[nums.length+1];

        preSum[0] = 0;
        for(int i = 0; i < nums.length; i++){
            preSum[i+1] = preSum[i] + nums[i];
        }
    }


    public int sumRange(int i, int j) {
        if(i == j){
            return preSum[j+1] - preSum[j];
        }
        else {
            return preSum[j+1] - preSum[i];
        }

    }
}

