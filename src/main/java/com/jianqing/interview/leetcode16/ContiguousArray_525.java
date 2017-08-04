package com.jianqing.interview.leetcode16;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jianqingsun on 7/22/17.
 *
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 *
 * 找连续的子数组， 使得0 和 1 的数量相同
 * 用累加和 (特殊的累加和， 遇0 算 -1 , 遇1  就算 1 ) 和 hashmap 保存 和的 index
 * 然后找和 ， 如果以前遇到过， 算最大
 */
public class ContiguousArray_525 {

    public int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }

        Map<Integer, Integer> sumToIndex = new HashMap<>(); // key : sum, val : sum 的index
        sumToIndex.put(0, -1); // 这个不能丢
        int sum = 0, max = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumToIndex.containsKey(sum)) { //
                max = Math.max(max, i - sumToIndex.get(sum));
            }
            else {
                sumToIndex.put(sum, i);
            }
        }

        return max;
    }
}
