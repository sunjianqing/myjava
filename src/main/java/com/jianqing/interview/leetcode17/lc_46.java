package com.jianqing.interview.leetcode17;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianqing_sun on 11/10/17.
 */
public class lc_46 {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        dfs(res, current, nums);
        return res;
    }

    public void dfs(List<List<Integer>>  res, List<Integer> current, int[] nums) {
        if(current.size() ==  nums.length){
            res.add(new ArrayList(current));
            return;
        }

        for(int i = 0 ; i < nums.length; i ++) {
            if(current.contains(nums[i])){
                continue;
            }
            current.add(nums[i]);
            dfs(res, current, nums);
            current.remove(current.size() - 1);
        }

    }
}
