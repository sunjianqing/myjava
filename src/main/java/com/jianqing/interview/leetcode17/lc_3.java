package com.jianqing.interview.leetcode17;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jianqing_sun on 10/13/17.
 *
 *  Longest Substring Without Repeating Characters
 *
 *  双指针
 */
public class lc_3 {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }


}
