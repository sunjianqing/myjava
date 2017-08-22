package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 8/16/17.
 */
public class RemoveDuplicatesfromSortedArray_26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1)
            return 1;
        int id = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[id++] = nums[i];
            }
        }

        return id;
    }
}
