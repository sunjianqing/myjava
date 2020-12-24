package com.jianqing.interview.facebook.lc20;

import java.util.HashMap;
import java.util.Map;

/**
 * 给一字符串， 找最长的substring T that contains at most k distinct characters
 * (Hard)
 * Two pointer
 *
 * 1. Sliding window
 * 2. k chars + index => map
 */
public class LC_340_LongestSubstringwithAtMostKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() ==0 ) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();

        int max = 0;
        int i,j; // two pointers

        int n = s.length();

        for (i = 0, j = 0; i < n; i++) {
            // move j to right side
            while (j < n && map.size() <= k) {
                char c = s.charAt(j);

                // c is the map
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                }
                else // c is not in the map
                {
                    if(map.size() == k) break; // 没法加进 子串， 就跳出

                    map.put(c, 1);
                }
                j++;
            }

            max = Math.max(max, j - i);

            // move i to right side
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int cnt = map.get(c);
                if (cnt > 1) {
                    map.put(c, cnt - 1);
                }
                else {
                    map.remove(c);
                }
            }

        }
        return max;
    }
}
