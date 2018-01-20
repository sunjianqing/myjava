package com.jianqing.interview.leetcode16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jianqing_sun on 1/16/18.
 */
public class MajorityElementII_229 {
    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<Integer>();

        if (nums.length == 1) {
            return new ArrayList<>(Arrays.asList(nums[0]));
        }

        int count1 = 0, count2 = 0, candidate1 = nums[0], candidate2 = nums[1];
        List<Integer> res = new ArrayList<>();

        int i = 0;
        while (i < nums.length) {
            if (nums[i] == candidate1) {
                count1++;
            } else if (nums[i] == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
            i++;
        }

        // verify candidate1 , candidate2
        count1 = 0;
        count2 = 0;

        for (i = 0; i < nums.length; i++) {
            if (nums[i] == candidate1) {
                count1++;
            } else if (nums[i] == candidate2) {
                count2++;
            }
        }

        if (count1 > nums.length / 3) {
            res.add(candidate1);
        }

        if (count2 > nums.length / 3) {
            res.add(candidate2);
        }

        return res;

    }
}
