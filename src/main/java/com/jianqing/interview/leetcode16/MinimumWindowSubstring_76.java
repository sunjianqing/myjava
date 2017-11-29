package com.jianqing.interview.leetcode16;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jianqingsun on 7/18/17.
 * <p>
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * For example, S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
 * <p>
 * Note: If there is no such window in S that covers all characters in T, return the emtpy string "".
 * <p>
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 * <p>
 * <p>
 * https://discuss.leetcode.com/topic/30941/here-is-a-10-line-template-that-can-solve-most-substring-problems
 * <p>
 * https://segmentfault.com/a/1190000003707313
 */
public class MinimumWindowSubstring_76 {
    public static void main(String[] args) {
        MinimumWindowSubstring_76 m = new MinimumWindowSubstring_76();
        //String s = m.minWindow("ADOBECODEBANC", "ABC");
        String s = m.minWindow("bba", "ab");

        System.out.println(s);

    }

    public String minWindow(String S, String T) {

        Map<Character, Integer> tmap = new HashMap<>();

        for (int i = 0; i < T.length(); i++) {
            tmap.put(T.charAt(i), tmap.containsKey(T.charAt(i)) ? tmap.get(T.charAt(i)) + 1 : 1);
        }

        Map<Character, Integer> tmp = new HashMap<>(tmap);
        Map<Character, Integer> curmap = new HashMap<>();

        int matched = 0;
        int start = 0;
        int end = 0;
        String window = null;

        for (; start < S.length(); start++) {
            if (tmp.containsKey(S.charAt(start))) {
                break;
            }
        }
        end = start;


        while (end < S.length()) {
            Character c = S.charAt(end);
            curmap.put(c, curmap.containsKey(c) ? curmap.get(c) + 1 : 1);

            if (!tmp.containsKey(c)) {
                end++;
                continue;
            }

            // 一旦找到了match ， 就一直match了， 就是找更小的了
            if (matched != T.length() && tmp.containsKey(c) && tmp.get(c) > 0) {
                matched++;
                tmp.put(c, tmp.get(c) - 1);
            }

            if (matched == T.length()) {
                if (window == null) // 第一次发现window
                    window = S.substring(start, end + 1);
                else {
                    if (end - start + 1 < window.length())
                        window = S.substring(start, end + 1);
                }

                // move start
                while (start < end) {
                    Character s = S.charAt(start);
                    if (!tmap.containsKey(s)) {
                        start++;
                        continue;
                    }

                    if (curmap.get(s) > tmap.get(s)) {
                        curmap.put(s, curmap.get(s) - 1);
                        start++;
                    } else {
                        if (end - start + 1 < window.length()) {
                            window = S.substring(start, end + 1);
                        }
                        break;
                    }
                }

                tmp = new HashMap<>(tmap);

            }
            end++;


        }


        return window == null ? "" : window;
    }

}
