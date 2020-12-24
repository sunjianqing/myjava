package com.jianqing.interview.facebook.lc20;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 可以把order字符串转成一个number map
 *
 * 比如 "hlabcdefgijkmnopqrstuvwxyz" 每个字符都有一个序号
 *
 * [
 *  'h' -> 0
 *  'l' -> 1
 *
 * ]
 *
 * 然后一边扫描只比较相邻的两个，因为suppose升序
 */
public class LC_953_VerifyinganAlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> cmap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            cmap.put(order.charAt(i), i);
        }

        for (int i = 1; i < words.length; i++) {
            if (bigger(words[i-1], words[i], cmap))
                return false;
        }

        return true;
    }

    private boolean bigger(String w1, String w2, Map<Character, Integer> cmap) {
        int m = w1.length();
        int n = w2.length();

        for (int i = 0; i < m && i < n; i++) {
            char c1 = w1.charAt(i);
            char c2 = w2.charAt(i);

            if (c1 != c2) {
                return cmap.get(c1) > cmap.get(c2);
            }
        }

        return m > n;
    }
}
