package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 11/10/16.
 */
public class SingleNumber_136 implements Solution {
    @Override
    public void solution() {
        int nums[] = {2, 2, 1, 3, 3};
        this.singleNumber(nums);
    }

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
