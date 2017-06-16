package com.jianqing.interview.leetcode16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jianqing_sun on 4/13/17.
 */
public class PermutationsII_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (nums.length == 0)
            return res;

        boolean[] visited = new boolean[nums.length];
        List<Integer> current = new ArrayList<>();

        Arrays.sort(nums);

        dfs(nums, res, current, visited);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> current, boolean[] visited) {
        if (current.size() == nums.length) {
            res.add(new ArrayList<Integer>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == false) // 避免重复结果， 上一步i-1 的时候已经加过了
                continue;
            if (visited[i]) // 已经加到备选答案了， 不能再用了
                continue;

            current.add(nums[i]);
            visited[i] = true;
            dfs(nums, res, current, visited);
            visited[i] = false;
            current.remove(current.size() - 1);
        }
    }
}