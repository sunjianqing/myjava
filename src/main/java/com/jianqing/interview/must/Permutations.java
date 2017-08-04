package com.jianqing.interview.must;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianqingsun on 3/4/17.
 https://leetcode.com/problems/permutations/#/discuss
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List tmp, int[] nums) {
        if (tmp.size() == nums.length) {
            list.add(new ArrayList<Integer>(tmp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if(tmp.contains(nums[i])){
                    continue;
                }
                tmp.add(nums[i]);
                backtrack(list, tmp, nums);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
