package com.jianqing.interview.facebook.lc20;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目大意
 * 数组 1<= a(i) <= n
 * 找里面所有的重复的元素
 *
 * 解法
 * 就是每碰到一个数k， 去吧相对应的nums[k]上的数去改成负的，如果再碰见负数就说明重复！
 *
 */
public class LC_442_FindAllDuplicatesinanArray {
    // when find a number i, flip the number at position i-1 to negative.
    // if the number at position i-1 is already negative, i is the number that occurs twice.

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return res;
    }
}
