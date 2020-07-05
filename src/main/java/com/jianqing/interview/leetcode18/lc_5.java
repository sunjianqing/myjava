package com.jianqing.interview.leetcode18;

/**
 * Longest Palindromic Substring
 */
public class lc_5 {

    public static void main(String[] args) {
        lc_5 solution = new lc_5();
        System.out.println(solution.longestPalindrome("aba"));
        System.out.println(solution.longestPalindrome("acbabccbb"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int start = 0;
        int end = 0;
        int n = s.length();
        int maxLen = 1;

        int[][] dp = new int[n][n];

        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (j - i == 1) {
                           dp[i][j] = 2;
                        }
                        else {
                            dp[i][j] = dp[i+1][j-1] == 0 ? 0 : dp[i+1][j-1] + 2;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] > maxLen) {
                    maxLen = dp[i][j];
                    start = i;
                    end = j;
                }

            }
        }

        return s.substring(start, end+1);
    }

}
