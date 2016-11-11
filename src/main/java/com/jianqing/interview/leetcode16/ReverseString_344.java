package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 11/9/16.
 *
 * Other solutions:
 *  1. stack
 *  2. create another empty string , and add element throught the last of original string
 *  3. recursive
 */
public class ReverseString_344 implements Solution {
    @Override
    public void solution() {

        this.reverseString("");
    }

    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            char t = chars[i];
            chars[i] = chars[j];
            chars[j] = t;

            i++;
            j--;
        }

        return String.valueOf(chars);

    }
}
