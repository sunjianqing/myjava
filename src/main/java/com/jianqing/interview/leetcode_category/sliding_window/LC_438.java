package com.jianqing.interview.leetcode_category.sliding_window;

import java.util.*;

public class LC_438 {

    public static void main(String[] args) {
        LC_438 lc = new LC_438();

        List<Integer> anagrams = lc.findAnagrams("cbaebabacd", "abc");
        System.out.println(anagrams);
    }

    // 这个解法是先找到一个大的满足条件的窗口，然后慢慢移动左指针
    public List<Integer> findAnagrams(String s, String t) {
        List<Integer> result = new LinkedList<>();
        if (t.length() > s.length()) return result;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> initMap = new HashMap<>(map);

        int count = map.size();  // !!! count 是map 的size ， 因为会有字符重复
        int l = 0, r = 0;

        while (r < s.length()) {
            char c = s.charAt(r);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) count --;
            }

            r++;

            while (count == 0) { // count = 0 说明， 所有字符都找到了
                char tempC = s.charAt(l);
                if (map.containsKey(tempC)) {
                    map.put(tempC, map.get(tempC) + 1);
                    if (map.get(tempC) > 0) {
                        count ++;
                    }
                }

                if (r - l == t.length()) {
                    result.add(l);
                }

                l++; // count = 0 的时候，说明再大窗口下， 已经可能有解了。 上面两个不发生， l 也要往前走
            }

        }

        return result;
    }
}
