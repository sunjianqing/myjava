package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 12/7/16.
 */
public class HouseRobber_198 implements  Solution {
    @Override
    public void solution() {

    }

    // Time Complexity : O(n)
    // Space Complexity : O(n)
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        if(nums.length <= 1)
            return nums[0];

        int[] maxArr = new int[nums.length];
        int max =  nums[0];
        maxArr[0] = nums[0];
        maxArr[1] = Math.max(nums[0],nums[1]);
        max = Math.max(maxArr[0], maxArr[1]);
        if(nums.length > 2){
            int i = 2;
            while (i < nums.length){
                maxArr[i] = Math.max(nums[i] + maxArr[i-2], maxArr[i-1]) ;
                max = Math.max(maxArr[i], max);
                i++;
            }
        }

        return max;

    }
}
