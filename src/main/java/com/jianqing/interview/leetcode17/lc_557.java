package com.jianqing.interview.leetcode17;

/**
 * Created by jianqing_sun on 10/11/17.
 *
 */
public class lc_557 {
    public String reverseWords(String s) {
        StringBuffer sb = new StringBuffer();
        String[] split = s.split(" ");
        for(String sp : split) {
            if(sb.length() != 0 )
                sb.append(" ");

            sb.append(reverse(sp));
        }

        return sb.toString();
    }

    private String reverse(String s) {
        char[] chars = s.toCharArray();
        int start = 0 ;
        int end = chars.length - 1;
        while (start < end) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
        return new String(chars);
    }
}
