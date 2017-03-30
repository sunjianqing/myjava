package com.jianqing.interview.leetcode16;

import java.util.*;

/**
 * Created by jianqing_sun on 3/29/17.
 */
public class LargestDivisibleSubset_368 {

    public static void main(String[] args) {
        LargestDivisibleSubset_368 l = new LargestDivisibleSubset_368();
        l.largestDivisibleSubset(new int[]{1,2,4,8,16});
    }
    public List<Integer> largestDivisibleSubset(int[] nums) {

        List<Integer> res = new ArrayList<>();
        Map<Integer, List<Integer>> dpRes = new HashMap<Integer, List<Integer>>();

        if (nums.length ==  0) {
            return res;
        }

        if(nums.length == 1) {
            res.add(nums[0]);
            return res;
        }
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }

        int[] dp = new int[nums.length];
        int max = 0;

        for (i = 1; i < nums.length; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (j = i - 1; j >= 0; j--) {
                if (nums[j] % nums[i] == 0) {
                    if (dp[j] + 1 > dp[i]) {
                        if (!dpRes.containsKey(j)) {
                            dpRes.put(i, Arrays.asList(nums[j], nums[i]));
                            dp[i] = 2;
                        } else {
                            List<Integer> newList = new ArrayList(dpRes.get(j));
                            newList.add(nums[i]);
                            dpRes.put(i, newList);
                            dp[i] = dp[j] + 1;
                        }

                        if (dp[i] > max) {
                            max = dp[i];
                        }
                    }

                }
            }
        }

        if (max != 0) {
            for (i = 0; i < nums.length; i++) {
                if (dpRes.get(i) != null && dpRes.get(i).size() == max) {
                    return dpRes.get(i);
                }
            }
        }

        // return array with 1st element
        return new ArrayList<>(Arrays.asList(nums[0]));

    }
}
