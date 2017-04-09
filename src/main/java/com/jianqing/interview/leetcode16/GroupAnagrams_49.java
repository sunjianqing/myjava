package com.jianqing.interview.leetcode16;

import java.util.*;

/**
 * Created by jianqingsun on 4/3/17.
 */
public class GroupAnagrams_49 {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res = new ArrayList<List<String>>();

        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (map.containsKey(key)) {
                 map.get(key).add(strs[i]);
            } else {
                List l = new ArrayList();
                l.add(strs[i]);
                map.put(key, l);
            }
        }

        res.addAll(map.values());

        return res;
    }
}
