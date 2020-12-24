package com.jianqing.interview.facebook.lc20;

import java.util.ArrayList;
import java.util.List;

public class LC_78_Subsets {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        LC_78_Subsets lc = new LC_78_Subsets();
        List<List<Integer>> res = lc.subsets(nums);
        System.out.println(res);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return res;
        }

        List<Integer> cur = new ArrayList<>();
        dfs(res, nums, 0, cur);
        return res;
    }

    public void dfs(List<List<Integer>> res, int[] nums, int start, List<Integer> cur) {
        res.add(new ArrayList<Integer>(cur));
        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            dfs(res, nums, i+1, cur);
            cur.remove(cur.size() -1);
        }
    }
}
