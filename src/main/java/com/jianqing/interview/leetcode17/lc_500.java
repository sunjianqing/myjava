package com.jianqing.interview.leetcode17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jianqing_sun on 10/10/17.
 * Keyboard Row
 */
public class lc_500 {
    public String[] findWords(String[] words) {
        String[] strs = {"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};

        List<String> res = new ArrayList<String>();

        Map<Character, Integer> map = new HashMap<>();
        int i = 1;
        for (String s : strs) {
            for (Character c : s.toCharArray()) {
                map.put(c, i);
            }
            i++;
        }
        for (String word : words) {
            char[] chars = word.toCharArray();
            int line = map.get(Character.toUpperCase(chars[0]));
            boolean found = true;
            for (int j = 1; j < chars.length; j++) {
                int currentLine = map.get(Character.toUpperCase(chars[j])) ;
                if(currentLine != line ) {
                    found = false;
                    break;
                }
            }
            if(found)
                res.add(word);
        }

        return res.toArray(new String[0]);
    }
}
