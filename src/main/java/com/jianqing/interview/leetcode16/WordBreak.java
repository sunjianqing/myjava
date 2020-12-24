package com.jianqing.interview.leetcode16;

import java.util.HashSet;
import java.util.List;

/**
 * Created by jianqingsun on 5/12/17.
 * Word Break
 * DP
 *
 * dp[i] 表示 i 长度的子串能不能被 segmented ， 所以dp[i] 等于 所有小于i 的 j 的子串 dp[i-j] 跟 从 i-j 到i 的 substring 在dict 取与
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.isEmpty()) {
            return true;
        }

        HashSet<String> set = new HashSet<>(wordDict);

        int n = s.length();
        boolean[] dp = new boolean[n + 1];

        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for( int j = 1; j<=i; j++){
                String tmp = s.substring(i-j, i);
                if( set.contains(tmp) && dp[i-j]){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
