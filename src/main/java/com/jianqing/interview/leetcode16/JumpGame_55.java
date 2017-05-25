package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 4/24/17.
 */
public class JumpGame_55 {

    // 超时
    public boolean canJump(int[] nums) {

        if(nums == null || nums.length == 0){
            return false;
        }

        int[] dp = new int[nums.length];

        dp[0] = nums[0] >= 0 ? 1 : 0;

        for(int i = 0 ; i < nums.length; i++) {
            for(int j = 0 ; j < i ; j++){
                if(dp[j] != 0 && j + nums[j] >= i) {
                    dp[i] = 1;
                    break;
                }
            }
        }

        return dp[nums.length - 1] == 1;
    }

    // Greedy
    public boolean canJump2(int[] A) {
        // think it as merging n intervals
        if (A == null || A.length == 0) {
            return false;
        }
        int farthest = A[0];
        for (int i = 1; i < A.length; i++) {
            if (i <= farthest && A[i] + i >= farthest) {
                farthest = A[i] + i;
            }
        }
        return farthest >= A.length - 1;
    }
}
