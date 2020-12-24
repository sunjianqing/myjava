package com.jianqing.interview.facebook.lc20;

/**
 * Valid Palindrome II
 *
 * 给一个字符串， 最多允许delete一个字符， 能否形成Palindrome
 *
 * 递归
 */
public class LC_680_ValidPalindromeII {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;

        int i = 0;
        int j = s.length() - 1;

        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return checkPalindrome(s.substring(i + 1, j + 1)) || checkPalindrome(s.substring(i, j));
            }
        }
        return true;
    }

    private boolean checkPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
