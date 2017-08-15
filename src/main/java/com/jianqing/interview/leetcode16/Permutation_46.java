package com.jianqing.interview.leetcode16;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianqing_sun on 8/3/17.
 *
 * https://leetcode.com/problems/permutations/discuss/
 *
 *
 */
public class Permutation_46 {

    public static void main(String[] args) {
        Permutation_46 p = new Permutation_46();
        List<List<Integer>> res = p.permute(new int[]{1, 2, 3});
        for(List<Integer> l : res){
            for(Integer ig : l)
                System.out.print(ig +" ");
            System.out.println("");
        }

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(nums, res, new ArrayList<Integer>(), 0);
        return res;
    }

    private void helper(int[] nums, List<List<Integer>> res, List<Integer> tmp, int i){
        if(tmp.size() == nums.length){
            res.add(new ArrayList<Integer>(tmp));
            return;
        }

        for( int j = i ; j < nums.length; j++){
            swap(nums, i, j);
            tmp.add(nums[i]);
            helper(nums, res, tmp, i+1);
            tmp.remove(tmp.size() -1);
            swap(nums, j, i);
        }
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
