package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 1/13/17.
 */
public class PartitionEqualSubsetSum_416 implements Solution {
    @Override
    public void solution() {

    }

    /**
     * http://leetcodesolution.blogspot.com/2016/10/leetcode-partition-equal-subset-sum.html
     * 背包问题 解法
     */
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++)
            total += nums[i];

        if (total % 2 != 0)
            return false;

        int target = total / 2;
        // dp 二维数组 dp[i][j] 表示， 前i 个数字的子集合， 能否恰好达到j的容积
        // 递推公式是
        //  dp[i][j] = dp[i-1][j] || (j >=nums[i-1] && dp[i-1][j-nums[i-1]]).
        // 前i个元素达到和 j， 取决去要么不包含num[i-1]的前i-1个元素恰好达到j，
        // 要么是包含当前元素num[i-1], 且前i-1 个元素存在子集 和为j-num[i-1]的解
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        dp[0][0] = true; // 前0个元素的子集合， 达到0的容积， 所以是true

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j] || (j >= nums[i - 1] && dp[i - 1][j - nums[i - 1]]);
            }
        }
        return dp[nums.length][target];
    }

    /**
     * 滚动数组解法
     */

    public boolean canPartition2(int[] nums) {
        int total = 0;
        for(int i = 0; i<nums.length; i++)
            total += nums[i];

        if (total %2 != 0)
            return false;

        int target= total / 2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for(int i=1; i<=nums.length; i++) {
            for(int j=target; j >=0 ;j--) {
                dp[j] = dp[j] || (j >=nums[i-1] && dp[j-nums[i-1]]);
            }
        }
        return dp[target];
    }
}
