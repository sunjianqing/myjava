package com.jianqing.interview.leetcode16;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jianqingsun on 7/8/17.
 */
public class MaximumSizeSubarraySumEqualsk_325 {
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0 , -1 );  // 用于单个元素
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if(map.containsKey(sum - k )){
                int len = i - map.get(sum-k);
                max = Math.max(len, max);
            }
            else{
                map.put(sum, i); // 用i 记录出现当前这个sum 的位置
            }
        }

        return max;
    }

    // 如果不用-1 记录0

    public int maxSubArrayLen2(int[] nums, int k) {
        int sum = 0, max = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum == k) max = i + 1;
            else if (map.containsKey(sum - k)) max = Math.max(max, i - map.get(sum - k));
            if (!map.containsKey(sum)) map.put(sum, i);
        }
        return max;
    }
}
