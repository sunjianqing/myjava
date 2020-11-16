package com.jianqing.interview.leetcode18;

/**
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * 贪心的思想
 * 每次找到一个字符， 就在那个字符之后接着找， 如果找不到， 说明不是sub sequence
 *
 */
public class LC_392 {

    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (int i = 0;i < s.length(); i++) {
            char c = s.charAt(i);
            index = t.indexOf(c, index+1);
            if ( index < 0) {
                return false;
            }
        }
        return true;
    }

}
