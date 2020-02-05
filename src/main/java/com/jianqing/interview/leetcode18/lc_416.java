package com.jianqing.interview.leetcode18;

/**
 * Partition Equal Subset Sum
 */
public class lc_416 {
    public static void main(String[] args) {
        lc_416 lc = new lc_416();
        int[] nums = new int[]{2,2,3,5};
        boolean b = lc.canPartition(nums);
        System.out.println(b);

    }
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        if (sum % 2 == 1) {
            return false;
        }

        int mid = sum / 2;
        int l = nums.length;
        int[][] dp = new int[l + 1][sum + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= l; i++) {
            for (int j = 1; j <= mid; j++) {
                if ( (j >= nums[i - 1] && dp[i - 1][j - nums[i -1]] ==  1 ) || dp[i - 1][j] == 1){
                    dp[i][j] =1;
                }
            }
        }

        return dp[l][mid] == 1;

    }
}
