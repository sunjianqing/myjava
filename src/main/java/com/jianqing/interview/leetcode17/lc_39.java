package com.jianqing.interview.leetcode17;

import java.util.ArrayList;
import java.util.List;

/**
 * Combination Sum
 *
 * Created by jianqingsun on 1/4/18.
 */
public class lc_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if(candidates == null || candidates.length == 0){
            return res;
        }

        List<Integer> cur = new ArrayList<>();

        helper(candidates, res, cur, 0, target, 0);
        return res;
    }

    private void helper(int[] candidates, List<List<Integer>> res, List<Integer> cur, int curSum, int target, int start) {
        if(curSum > target)
            return;

        if (curSum == target) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i = start; i < candidates.length; i++){
            cur.add(candidates[i]);
            curSum += candidates[i];

            helper(candidates, res, cur, curSum, target, i);

            curSum -= candidates[i];
            cur.remove(cur.size()-1);
        }

    }

}
