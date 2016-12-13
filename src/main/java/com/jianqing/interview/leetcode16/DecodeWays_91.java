package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 12/12/16.
 *
 * Difficulty: Medium
 *
 * DP 问题
 * 对于第i个字符，往前退一个字符，如果有效(!=0) dp[i] += dp[i-1]
 * 接着！计算往前退两个字符的情况，如果有效(首字母不是0， 并且这两位组成的数>=1 <=26 其实是s[i - 2] == '1' || (s[i - 2] == '2' && s[i - 1] <= '6')， dp[i] += dp[i-2]
 * 所以dp[i] 是这两步合起来的和
 */
public class DecodeWays_91 implements Solution {
    @Override
    public void solution() {

    }
}
