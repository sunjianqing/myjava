package com.jianqing.interview.leetcode18;

/**
 * Distinct Subsequences
 *
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 *
 * dp[i][j] 表示S 的前 i 个字符， 跟 T 的前 j 个字符 的解
 *
 * 递推公式 就是判断 s[i-1] == t[j-1]
 * 如果等于， dp[i][j] 就有两种情况， 一种是 不取s[i-1] 作为subsequenece 的元素， 那就是dp[i-1][j] 一种是  取s[i-1] 作为subsequenece 的元素， 解就是dp[i-1][j-1]
 */
public class LC_115 {

    public static void main(String[] args) {
        float i = 1;
        for ( int j = 1; j < 31; j++) {
            i = i * 1.03f;
        }

        System.out.println(i);

        i = 0;
        for ( int j = 1; j < 31; j++) {
            i = (i + 2.6f) * 1.06f;
        }

        System.out.println(i);


    }
    public int numDistinct(String s, String t) {
        if (t == null && t.length() == 0) {
           return 1;
        }

        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m+1][n+1];


        for (int i =  0; i <= m; i++) {
            dp[i][0] = 1; //
        }

        for (int j = 1; j <= n; j++) {
            dp[0][j] = 0; //
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[m][n];
    }
}
