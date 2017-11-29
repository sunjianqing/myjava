package com.jianqing.interview.leetcode17;

/**
 * Maximum Subarray
 */
public class lc_53 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int cursum = nums[0];
        int max = cursum;
        for (int i = 1; i < nums.length; i++) {
            if(cursum >=0) {
                // cursum > 0 对于后续是正影响
                cursum += nums[i];
            }
            else
                cursum = nums[i]; // cursum 是负数， 不会对后面的最大值有贡献

            max = Math.max(cursum, max);
        }
        return max;
    }
}
