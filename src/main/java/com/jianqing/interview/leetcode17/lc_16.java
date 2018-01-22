package com.jianqing.interview.leetcode17;

import java.util.Arrays;

/**
 * Created by jianqingsun on 1/2/18.
 */
public class lc_16 {
    public int threeSumClosest(int[] nums, int target) {
        int sum = 0;
        if (nums.length <= 3) {

            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            return sum;
        }

        Arrays.sort(nums);

        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {

            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                    if (res == target)
                        return res;
                }

                if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return res;
    }

}