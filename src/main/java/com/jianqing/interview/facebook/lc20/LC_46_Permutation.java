package com.jianqing.interview.facebook.lc20;

import java.util.ArrayList;
import java.util.List;

/**
 * DFS backtracking
 */
public class LC_46_Permutation {
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0)
            return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(nums, res, cur);
        return res;
    }

    public void dfs (int[] nums, List<List<Integer>> res, List<Integer> cur) {
        if( cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
        }

        for (int i = 0; i < nums.length; i++) {
            if (!cur.contains(nums[i])) {
                cur.add(nums[i]);
                dfs(nums, res, cur);
                cur.remove(cur.size()-1);
            }
        }
    }
}
