package com.jianqing.interview.leetcode16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jianqing_sun on 10/17/17.
 *
 * 39. Combination Sum

 Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [2, 3, 6, 7] and target 7,
 A solution set is:
 [
 [7],
 [2, 2, 3]
 ]

 */
public class CombinationSum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);
        List<Integer> current = new ArrayList<>();
        dfs(target, 0, res, current, candidates);
        return res;
    }

    private void dfs(int target, int start, List<List<Integer>> res, List<Integer> current, int[] candidates) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if(target < candidates[i]) {
                break;
            }

            current.add(candidates[i]);
            dfs(target - candidates[i], i, res, current, candidates);
            current.remove(current.size()-1);
        }

        return;
    }

}