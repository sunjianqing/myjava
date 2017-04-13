package com.jianqing.interview.leetcode16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jianqing_sun on 4/12/17.
 */
public class CombinationII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (candidates == null || candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates);

        List<Integer> curList = new ArrayList<Integer>();

        helper(0, res, curList, candidates, target);

        return res;
    }

    public void helper(int start, List<List<Integer>> res, List<Integer> curList, int[] candidates, int target) {

        if (target == 0) {
            res.add(new ArrayList(curList));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i != start && candidates[i] == candidates[i - 1])
                continue;
            if (target < candidates[i]) {
                // 剪枝
                break;
            }
            curList.add(candidates[i]);
            helper(i + 1, res, curList, candidates, target - candidates[i]);
            curList.remove(curList.size() - 1);
        }

        return;
    }


}
