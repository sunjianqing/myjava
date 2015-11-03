package com.jianqing.interview.leetcode;

/**
 * Created by jianqsun on 8/9/14.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        boolean re = false;

        if(s==null || s.isEmpty())
            return true;


        int i = 0 ;
        int j = s.length()-1;

        while(i<j){
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'z'
                    ){
                if (s.charAt(j) >= 'A' && s.charAt(j) <= 'z' )
                {
                    if(s.toLowerCase().charAt(i) != s.toLowerCase().charAt(j))
                    return false;
                }

            }
            i++;

            if(s.charAt(j) >= 'A' && s.charAt(j) <= 'z'){
                if (s.charAt(i) >= 'A' && s.charAt(i) <= 'z' )
                {
                    if(s.toLowerCase().charAt(i) != s.toLowerCase().charAt(j))
                    return false;
                }

            }
            j--;

        }
        return true;
    }

    public static void main(String[] args){
        ValidPalindrome vp = new ValidPalindrome();
        System.out.println(vp.isPalindrome("a.b,."));
    }
}
