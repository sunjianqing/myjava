package com.jianqing.interview.leetcode16;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jianqingsun on 7/18/17.
 * <p>
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC" Minimum window is "BANC".
 * <p>
 * Note: If there is no such window in S that covers all characters in T, return the emtpy string "".
 * <p>
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 * <p>
 * <p>
 * https://discuss.leetcode.com/topic/30941/here-is-a-10-line-template-that-can-solve-most-substring-problems
 * <p>
 * https://segmentfault.com/a/1190000003707313
 *
 * 双指针， 找到target 的时候， 尽量右移左指针
 */
public class MinimumWindowSubstring_76 {

    public static void main(String[] args) {

        MinimumWindowSubstring_76 m = new MinimumWindowSubstring_76();

        String s = m.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);

    }

    public String minWindow(String S, String T) {

        Map<Character, Integer> targetMap = new HashMap<>();
        Map<Character, Integer> currentSourceMap = new HashMap<>();


        for (Character c : T.toCharArray()) {
            if (targetMap.containsKey(c))
                targetMap.put(c, targetMap.get(c) + 1);
            else {
                targetMap.put(c, 1);
            }
        }

        int start = 0;
        int end = 0;
        String window = S;
        for (; end < S.length(); end++) {
            Character schar = S.charAt(end);
            currentSourceMap.put(schar, currentSourceMap.containsKey(schar) ? currentSourceMap.get(schar) + 1 : 1);

            // compare to two map
            boolean found = true;
            for (Map.Entry<Character, Integer> entry : targetMap.entrySet()) {
                if (currentSourceMap.containsKey(entry.getKey()) && currentSourceMap.get(entry.getKey()) >= targetMap.get(entry.getKey())) {
                    found &= found;
                } else {
                    found = false;
                }
            }

            if (found) {
                if (end - start + 1 < window.length()) {
                    window = S.substring(start, end + 1);
                }

                if (targetMap.containsKey(schar) && currentSourceMap.get(schar) > targetMap.get(schar)) {
                    Map tmp = new HashMap<Character,Integer>(currentSourceMap);
                    while (start < end) {
                        if (!targetMap.containsKey(S.charAt(start))) {
                            start++;
                            continue;
                        }
                        //System.out.println(S.substring(start, end +1));
                        String ss = S.substring(start, end +1);
                        if (currentSourceMap.get(S.charAt(start)) >= targetMap.get(S.charAt(start))) {

                            currentSourceMap.put(S.charAt(start), currentSourceMap.get(S.charAt(start)) - 1);
                            if (currentSourceMap.get(S.charAt(start)) < targetMap.get(S.charAt(start))) {
                                if (end - start + 1 < window.length()) {
                                    window = S.substring(start, end + 1);
                                }
                                break;
                            }
                        }
                        else {
                            break;
                        }
                        start++;

                    }
                    currentSourceMap = tmp;

                }
            }


        }

        return window;
    }

}
