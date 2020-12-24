package com.jianqing.interview.facebook.lc20;

public class LC_125_ValidPalindrome {


    public static void main(String[] args) {
        LC_125_ValidPalindrome lc = new LC_125_ValidPalindrome();
        boolean palindrome = lc.isPalindrome("0P");
        System.out.println(palindrome);
    }

    public boolean isPalindrome(String s) {

        if (s == null || s.length() == 0) return true;

        int head = 0;
        int tail = s.length() - 1;

        while (head <= tail) {

            if (!Character.isLetterOrDigit(s.charAt(head))){
                head++;
            }
            else if (!Character.isLetterOrDigit(s.charAt(tail))){
                tail--;
            }
            else {
                if (Character.toLowerCase(s.charAt(head)) != Character.toLowerCase(s.charAt(tail))) {
                    return false;
                }
                head++;
                tail--;
            }
        }
        return true;

    }

    public boolean isPalindrome2(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head <= tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if(!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }

        return true;
    }

}
