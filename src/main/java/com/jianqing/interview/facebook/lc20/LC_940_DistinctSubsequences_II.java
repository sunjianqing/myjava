package com.jianqing.interview.facebook.lc20;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S, count the number of distinct, non-empty subsequences of S .
 *
 * Since the result may be large, return the answer modulo 10^9 + 7.
 *
 * Input: "aaa"
 * Output: 3
 * Explanation: The 3 distinct subsequences are "a", "aa" and "aaa".
 *
 * Input: "aba"
 * Output: 6
 * Explanation: The 6 distinct subsequences are "a", "b", "ab", "ba", "aa" and "aba".
 *
 * 思路如下
 *
 * 先想如果没有重复字符，
 *
 * dp[i] = dp[i-1]  (不包含s[i] 的所有子序列) + dp[i-1] （加了s[i], 相当于以前的所有的都形成了一个新的子序列）
 *
 * 如果有重复， 看看重复咋来的
 *
 * 比如
 *
 * x x x x a x x x [a]
 *
 * 新来的a 会跟最后一次a出现位置之前的所有子序列组成重复的子序列
 * 所以得减去 dp[last[a] - 1] 的结果
 *
 * 所以状态方程式
 * dp[i] = 2 * dp[i-1] - dp[last[s(i)] - 1]
 *
 * 最后再减1 ， 把空的去掉
 *
 * dp[i] 有可能很大， 记得mod
 */
public class LC_940_DistinctSubsequences_II {

    public int distinctSubseqII(String S) {
        int mod = (int)1e9 + 7;
        int len = S.length();
        int[] dp = new int[len+1];
        dp[0] = 1;
        Map<Character, Integer> last = new HashMap<>();

        for (int i = 1; i <= len; i++) {
            dp[i] = 2 * dp[i-1];
            char c = S.charAt(i-1);
            if (last.containsKey(c)) {
                dp[i] -=  dp[last.get(c)-1];
            }
            last.put(c, i);
            dp[i] = dp[i] < 0 ? dp[i] + mod : dp[i] % mod;
        }
        dp[len] --;

        return dp[len];
    }
}
