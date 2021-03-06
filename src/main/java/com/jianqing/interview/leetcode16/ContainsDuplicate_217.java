package com.jianqing.interview.leetcode16;

import java.util.HashSet;

/**
 * Created by jianqing_sun on 11/29/16.
 */
public class ContainsDuplicate_217 implements Solution {
    @Override
    public void solution() {

    }

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;

        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i<nums.length; i++){
            if(!set.add(nums[i]))
                return true;
        }
        return false;
    }
}
