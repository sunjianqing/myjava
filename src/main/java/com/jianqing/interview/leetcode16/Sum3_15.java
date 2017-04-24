package com.jianqing.interview.leetcode16;

import java.util.*;

/**
 * Created by jianqingsun on 3/3/17.
 */
public class Sum3_15 {

    public List<List<Integer>> threeSum(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else{
                map.put(nums[i], 1);
            }
        }

        int a, b, c;

        for (int i = 0; i < nums.length-2; i++) {
            c = nums[i];
            for (int j = i+1; j < nums.length; j++) {

                    b = nums[j];
                    // find a
                    a = (-1)* c - b;
                    if (map.containsKey(a)) {
                        if (a == b || a == c ) {
                            if (map.get(a) > 1) {
                                // add a,b,c
                                res.add(Arrays.asList(a,b,c));
                            }
                        } else {
                            // add a,b,c
                            res.add(Arrays.asList(a,b,c));
                        }

                    }


            }
        }

        // remove duplicate from res

        return res;

    }
}
