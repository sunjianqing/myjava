package com.jianqing.interview.leetcode_category.double_pointer;

import java.util.List;

public class LC_524 {

    public String findLongestWord(String s, List<String> d) {

        String res = "";

        for (String t : d) {
            if(isSubstr(s, t)) {
                if (t.length() > res.length()) {
                    res = t;
                }
                else if(t.length() == res.length() && t.compareTo(res) < 0) {
                    res = t;
                }
            }
        }

        return res;
    }

    private boolean isSubstr(String s, String t) {

        for(int i = 0,j = 0; i < s.length();) {
            if(s.charAt(i) == t.charAt(j)) {
                j++;
                if(j == t.length()) {
                    return true;
                }
            }
            i++;
        }

        return false;
    }
}
