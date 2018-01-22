package com.jianqing.interview.leetcode16;

import java.util.Arrays;

/**
 * Created by jianqingsun on 1/18/18.
 * Wiggle Sort
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * <p>
 * For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 */
public class WiggleSort_280 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);

        // 一对对交换
        for (int i = 2; i < nums.length; i++) {
            int t = nums[i];
            nums[i] = nums[i - 1];
            nums[i - 1] = t;
        }

    }
}
