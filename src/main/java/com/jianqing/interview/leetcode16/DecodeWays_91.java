package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 12/12/16.
 * <p>
 * Difficulty: Medium
 * <p>
 * DP 问题
 * 对于第i个字符，往前退一个字符，如果有效(!=0) dp[i] += dp[i-1]
 * 接着！计算往前退两个字符的情况，
 * 如果有效(首字母不是0， 并且这两位组成的数>=1 <=26 其实是s[i - 2] == '1' || (s[i - 2] == '2' && s[i - 1] <= '6')， dp[i] += dp[i-2]
 * 所以dp[i] 是这两步合起来的和
 */
public class DecodeWays_91 implements Solution {
    @Override
    public void solution() {

    }

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i < n; i++) {
            String first = s.substring(i - 1, i);
            int oneDigitNumber = Integer.valueOf(first);
            String second = s.substring(i - 2, i);
            int twoDigitNumber = Integer.valueOf(second);

            if(oneDigitNumber>0){
                dp[i] += dp[i-1];
            }

            if(twoDigitNumber>=10 && twoDigitNumber <= 26){
                dp[i] += dp[i-2];
            }

        }

        return dp[n];
    }
}
