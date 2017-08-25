package com.jianqing.interview.facebook;

/**
 * Created by jianqingsun on 8/8/17.
 * 状态：和Mininum Edit Distance这类题目一样。
 dp[i][j]表示s[0:i-1]是否能和p[0:j-1]匹配。

 递推公式：由于只有p中会含有regular expression，所以以p[j-1]来进行分类。
 p[j-1] != '.' && p[j-1] != '*'：dp[i][j] = dp[i-1][j-1] && (s[i-1] == p[j-1])
 p[j-1] == '.'：dp[i][j] = dp[i-1][j-1]

 而关键的难点在于 p[j-1] = '*'。由于星号可以匹配0，1，乃至多个p[j-2]。
 1. 匹配0个元素，即消去p[j-2]，此时p[0: j-1] = p[0: j-3]
 dp[i][j] = dp[i][j-2]

 2. 匹配1个元素，此时p[0: j-1] = p[0: j-2]
 dp[i][j] = dp[i][j-1]

 3. 匹配多个元素，此时p[0: j-1] = { p[0: j-2], p[j-2], ... , p[j-2] }
 dp[i][j] = dp[i-1][j] && (p[j-2]=='.' || s[i-2]==p[j-2])
 */
public class RegularExpressionMatching_10 {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null)
            return false;


        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;

        for(int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '*'){
                if(i > 0 && dp[0][i-1]){
                    dp[0][i+1] = true;
                }

                if(i == 0){
                    dp[0][i+1] = true;
                }
            }
        }

        for(int i = 1; i <= s.length(); i++) {
            for ( int j = 1; j <= p.length(); j++){
                if(p.charAt(j-1) == '.' ||  p.charAt(j-1) == s.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1];
                }

                if(p.charAt(j-1) == '*') {
                   if(s.charAt(i-1) != p.charAt(j-2) && p.charAt(j-2) != '.' ){
                        dp[i][j] = dp[i][j-2];
                   }
                   else{
                       dp[i][j] = dp[i-1][j] || dp[i][j-2]; // 如果s.charAt(i-1) = p.charAt(j-2) 就看dp[i-1][j] ， 如果p.charAt(j-2) = '.' 就看 dp[i][j-2]
                   }
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
