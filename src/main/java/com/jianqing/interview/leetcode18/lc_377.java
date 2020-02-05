package com.jianqing.interview.leetcode18;

/**
 * Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.
 * <p>
 * Example:
 * <p>
 * nums = [1, 2, 3]
 * target = 4
 * <p>
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * <p>
 * Note that different sequences are counted as different combinations.
 * <p>
 * Therefore the output is 7.
 */
public class lc_377 {
    // 如果 target 特别大， 就不要用这个方法了， 因为要开很大的dp 的数组， 那时就可以用top down + memorization 的方法了
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[target + 1];

        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int n : nums) {
                if (i >= n) {
                    dp[i] += dp[i - n];
                }
            }
        }

        return dp[target];
    }
}
