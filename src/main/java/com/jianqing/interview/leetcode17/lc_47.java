package com.jianqing.interview.leetcode17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jianqing_sun on 11/10/17.
 * Permutation II
 *
 */
public class lc_47 {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        int n = nums.length;
        boolean[] visited = new boolean[n];

        Arrays.sort(nums);
        dfs(res, current, nums, visited);
        return res;
    }

    public void dfs(List<List<Integer>>  res, List<Integer> current, int[] nums, boolean[] visited) {
        if(current.size() ==  nums.length){
            res.add(new ArrayList(current));
            return;
        }

        for(int i = 0 ; i < nums.length; i ++) {


            if(visited[i])
                continue;

            if(i > 0 && nums[i] == nums[i-1] && visited[i-1] == false){
                continue;
            }

            current.add(nums[i]);
            visited[i] = true;
            dfs(res, current, nums, visited);
            current.remove(current.size() - 1);
            visited[i] = false;
        }

    }
}
