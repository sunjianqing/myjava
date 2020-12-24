package com.jianqing.interview.facebook.lc20;

/**
 * DP
 *
 */

public class LC_1262_GreatestSumDivisiblebyThree {
    public static void main(String[] args) {
        LC_1262_GreatestSumDivisiblebyThree lc = new LC_1262_GreatestSumDivisiblebyThree();
        lc.maxSumDivThree(new int[]{3,6,5,1,8});
    }
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[]{0, Integer.MIN_VALUE, Integer.MIN_VALUE}; // 这里要过非常小的负数，以防第一步相加大于0

        for (int n : nums) {
            int[] dp2 = new int[3];
            for ( int i = 0; i < 3; i++) {
                int mod = (i + n) % 3;
                dp2[mod] = Math.max(dp[mod], dp[i] + n);
            }
            dp = dp2;
        }

        return dp[0];
    }
}
