package com.jianqing.interview.leetcode16;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jianqing_sun on 11/28/16.
 */
public class RansomNote implements Solution {
    @Override
    public void solution() {

    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0 ; i < magazine.length(); i++) {
            Character c = magazine.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, 1 + map.get(c));
            } else {
                map.put(c, 1);
            }
        }

        for (Character c : ransomNote.toCharArray()) {
            if (!map.containsKey(c))
                return false;
            else {
                if (map.get(c) == 0)
                    return false;
                map.put(c, map.get(c) - 1);
            }
        }

        return true;

    }
}
