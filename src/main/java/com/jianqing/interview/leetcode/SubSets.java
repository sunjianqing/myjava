package com.jianqing.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jianqsun on 8/6/14.
 */
public class SubSets {

    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] s) {
        if (s == null || s.length == 0) return res;
        Arrays.sort(s);
        List<Integer> list = new ArrayList<Integer>();
        dfs(list, 0, 0, s);
        return res;
    }

    private void dfs(List<Integer> list, int k, int count, int[] s) {
        if (count > s.length) return;
        if (count <= s.length) {
            res.add(new ArrayList<Integer>(list));
        }
        for (int i = k; i < s.length; i++) {
            list.add(s[i]);
            dfs(list, i + 1, count + 1, s);
            list.remove(list.size() - 1);
        }
    }

    // Iterative
    public List<List<Integer>> subsetsIter(int[] S) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());

        Arrays.sort(S);
        for(int i : S) {
            List<List<Integer>> tmp = new ArrayList<>();
            for(List<Integer> sub : res) {
                List<Integer> a = new ArrayList<>(sub);
                a.add(i);
                tmp.add(a);
            }
            res.addAll(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3};
        SubSets ss = new SubSets();
        ss.subsets(data);
    }

    public List<List<Integer>> subsetsAgain(int[] nums) {
        if(nums == null || nums.length == 0 )
            return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tmp =  new ArrayList<Integer>();
        helper(res, nums, 0, tmp);

        return res;
    }

    private void helper(List<List<Integer>>  res, int[] nums, int start, List<Integer> tmp){
        if(start > nums.length)
            return;

        if(start <= nums.length){
            res.add(new ArrayList<Integer>(tmp));
        }

        for(int i = start ; i < nums.length; i++){
            tmp.add(nums[i]);
            helper(res, nums, i+1, tmp);
            tmp.remove(tmp.size() - 1);
        }

        return;
    }


}
