package com.jianqing.interview.classic;

/**
 * Created by jianqing_sun on 4/4/17.
 * 最长公共子串
 * Longest Common Subsequence
 * <p>
 * 转换方程
 * dp[i][j] = max{ dp[i][j-1] && a[i] != b[j] , dp[i-1][j] && a[i] != b[j] , dp[i-1][j-1] + 1 && a[i] == b[j] }
 */
public class LCS {

    public static void main(String[] args) {
        LCS lcs = new LCS();

        //==========================

        String s1 = "bdcaba";
        String s2 = "abcbdab";

        String res = lcs.lcs("bdcaba", "abcbdab");
        System.out.println("\nLCS of " + s1 + " " + s2  +"  is " + res);

        //==========================
         s1 = "bdc";
         s2 = "abc";

        res = lcs.lcs(s1, s2);
        System.out.println("\nLCS of " + s1 + " "+ s2  +"  is " + res);

    }

    public String lcs(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= s2.length(); j++) {
            dp[0][j] = 0;
        }

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                int tmp;
                int max;
                if (chars1[i - 1] == chars2[j - 1]) {
                    tmp = dp[i-1][j-1] + 1;
                     max = findMax(tmp, dp[i-1][j], dp[i][j-1]);
                } else {
                     max = findMax(dp[i-1][j], dp[i][j-1]);
                }

                dp[i][j] = max;
            }
        }

        StringBuffer sb = new StringBuffer();
        print(sb, dp, chars1, chars2, chars1.length, chars2.length);

        return  sb.reverse().toString() ;
    }

    private int findMax(int a, int b, int c){
        if(a > b){
            if( a > c )
                return a;
            else
                return c;
        }
        else {
            if ( b > c)
                return b;
            else
                return c;
        }
    }

    private int findMax(int a, int b){
        return Math.max(a, b);
    }

    // 输出LCS序列
    public static void print(StringBuffer sb, int[][] arr, char[] X, char[] Y, int i, int j) {
        if(i == 0 || j == 0)
            return;
        if(X[i-1] == Y[j-1]) {
            sb.append(X[i-1]);
            System.out.print("element " + X[i-1] + " ");
            // 寻找的
            print(sb, arr, X, Y, i-1, j-1);
        }else if(arr[i-1][j] >= arr[i][j-1]) {
            print(sb, arr, X, Y, i-1, j);
        }else{
            print(sb, arr, X, Y, i, j-1);
        }
    }
}
