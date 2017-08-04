package com.jianqing.interview.leetcode16;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jianqingsun on 8/2/17.
 * Longest Substring with At Most Two Distinct Characters
 * <p>
 * Given S = “eceba”,
 * T is “ece” which its length is 3.
 *
 * 如果是k 个， 就把2换为k
 */
public class LongestSubstringwithAtMostTwoDistinctCharacters_159 {

    public static void main(String[] args) {
        LongestSubstringwithAtMostTwoDistinctCharacters_159 l = new LongestSubstringwithAtMostTwoDistinctCharacters_159();
        int res = l.lengthOfLongestSubstringTwoDistinct("abbcccdeee");
        System.out.println(res);
    }

    // left , right 指针， 加 hashmap
    // hashmap 记录次数， 如果hashmap 的size > 2 了， 就一直移动left 知道size <=2
    public int lengthOfLongestSubstringTwoDistinct(String s) {

        if (s == null || s.length() == 0)
            return 0;

        Map<Character, Integer> map = new HashMap<>();

        int left = 0, right = 0, maxLen = 0;
        while (right < s.length()) {

                Character c = s.charAt(right);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
                right ++;

                while(map.size() > 2) {
                    Character cc = s.charAt(left);
                    if(map.get(cc) > 0 ){
                        map.put(cc, map.get(cc) -1);
                    }

                    if(map.get(cc) == 0)
                        map.remove(cc);

                    left++;
                }


            maxLen = Math.max(maxLen, right - left);

        }

        return maxLen;

    }
}
