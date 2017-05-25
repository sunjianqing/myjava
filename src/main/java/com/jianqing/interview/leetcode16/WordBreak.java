package com.jianqing.interview.leetcode16;

import java.util.HashSet;
import java.util.List;

/**
 * Created by jianqingsun on 5/12/17.
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
