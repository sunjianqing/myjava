package com.jianqing.interview.leetcode16;

/**
 *
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Created by jianqingsun on 4/25/17.
 *
 * 双指针
 *
 * 先找到一个区间，然后在把左指针右移， 缩小范围
 */
public class MinimumSizeSubarraySum_209 {
    public int minSubArrayLen(int s, int[] nums) {

        if (nums == null || nums.length == 0 || s <= 0) {
            return 0;
        }

        if(nums[0] == s)
            return 1;

        int left = 0, right = 0;
        int len = nums.length + 1;
        int sum = 0;
        while (right < nums.length) {
            while( sum < s && right < nums.length ){
                sum += nums[right++];
            }

            while ( sum >= s ) {
                len = Math.min(len, right - left);
                sum -= nums[left++];
            }
        }

        if (len == nums.length + 1)
            return 0;
        else
            return len;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum_209 min = new MinimumSizeSubarraySum_209();
        min.minSubArrayLen(7, new int[]{2,3,1,2,4,3});
    }
}
