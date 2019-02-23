package com.jianqing.interview.leetcode18;

/*
    Input: [10,9,2,5,3,7,101,18]
    Output: 4
    Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 */
public class lc_300 {

    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int[] dp = new int[nums.length];

        int max = 1;
        for(int i = 0 ; i < nums.length; i++) {
            dp[i] = 1;
        }

        for( int i = 0 ; i < nums.length; i++) {
            for( int j = 0; j < i; j++){
                if(nums[i] > nums[j] && dp[j] >= dp[i]){
                    dp[i] = dp[j] + 1;
                    if(dp[i] > max){
                        max = dp[i];
                    }
                }
            }
        }

        return max;
     }

     // Solution 2 最优解 nlog(n), maintain 一个前面所有数据的递增序列， 并且尽量让最后一个最大的值小

}
