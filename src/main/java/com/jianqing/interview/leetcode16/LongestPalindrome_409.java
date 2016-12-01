package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 11/29/16.
 */
public class LongestPalindrome_409 implements Solution {
    public static void main(String[] args) {
        LongestPalindrome_409 lp = new LongestPalindrome_409();

        lp.solution();
    }
    @Override
    public void solution() {
        this.longestPalindrome("abccccdd");
    }

    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return 0;

        boolean[][] palin = new boolean[s.length()][s.length()];
        String res = "";
        int maxLen = 0;

        //从最后开始扫描
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || palin[i + 1][j - 1]))
                // 以下的code 是用来build palin矩阵的, 所以一直拿当年i 跟j 到最后比
                {
                    palin[i][j] = true;
                    if (maxLen < j - i + 1) {
                        maxLen = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }

        System.out.println("The longest palindrome is " + res);

        for(int i = 0; i<s.length(); i++){
            for(int j = 0; j< s.length(); j++){
                System.out.print(palin[i][j] + "\t");
            }
            System.out.println("");
        }
        return maxLen;
    }
}
