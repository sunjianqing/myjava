package com.jianqing.interview.leetcode16;

import java.util.Arrays;

/**
 * Created by jianqingsun on 4/21/17.
 */
public class Sum3Closest_16 {

    public int threeSumClosest(int[] nums, int target) {
        if (nums.length <= 3) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }

            return sum;
        }

        Arrays.sort(nums);
        int len = nums.length;
        int min = Integer.MAX_VALUE;

        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len - 2; i++) {
            int j = i + 1;
            int k = len - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - res) > Math.abs(target - sum)) {
                    res = sum;
                    if (res == target) return res;

                }
                if (sum > target)
                    k--;
                else
                    j++;
            }

        }
        return res;


    }
}
