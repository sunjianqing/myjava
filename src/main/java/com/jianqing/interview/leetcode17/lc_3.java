package com.jianqing.interview.leetcode17;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
        if (s == null || s.length() ==0) {
            return 0;
        }

        int start = 0, end = 0, max = 0;
        String longestStr = "";
        Map<Character, Integer> map = new HashMap<>();
        for (; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                start = map.get(s.charAt(end)) + 1; // 上一次出现的地方加1
                end = start;
                map.clear();
                map.put(s.charAt(start), start);
            }
            else {
                map.put(s.charAt(end), end);
                if (end - start + 1 > max) {
                    max = end - start + 1;
                    longestStr = s.substring(start, end + 1);
                }
            }
        }
        return max;
    }
}
