package com.jianqing.interview.leetcode16;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jianqingsun on 11/28/16.
 */
public class MajorityElement_169 implements Solution {
    @Override
    public void solution() {

    }

    public int majorityElement(int[] nums) {
        int mid = 1 + nums.length / 2;
        int res = nums[0];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, 1 + map.get(i));
                if (map.get(i) >= mid)
                    return i;
            } else
                map.put(i, 1);
        }

        return res;

    }
}
