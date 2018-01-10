package com.jianqing.interview.leetcode16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jianqing_sun on 1/9/18.
 */
public class Subset_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        helper(res, new ArrayList<Integer>(), nums, 0);
        return res;

    }

    private void helper(List<List<Integer>> res, List<Integer> tmp, int[] nums, int start) {
        res.add(new ArrayList<Integer>(tmp));

        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            helper(res, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
