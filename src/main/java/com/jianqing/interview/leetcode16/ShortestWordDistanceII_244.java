package com.jianqing.interview.leetcode16;

import java.util.*;

/**
 * Created by jianqingsun on 11/5/17.
 * 如果 ShortestWordDistance I 要call 多次 怎么办
 * <p>
 * build 两个linkedlist， 然后找最短距离
 */
public class ShortestWordDistanceII_244 {
    public static void main(String[] args) {
        ShortestWordDistanceII_244 sd = new ShortestWordDistanceII_244();
        int i = sd.shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "makes", "coding");
        System.out.println(i);

    }

    public int shortestDistance(String[] words, String word1, String word2) {
        Map<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i]))
                map.get(words[i]).add(i);
            else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(words[i], list);
            }

        }

        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);

        int min = words.length;
        int p1 = 0;
        int p2 = 0;
        while (p1 < l1.size() && p2 < l2.size()) {
            min = Math.min(Math.abs(l1.get(p1) - l2.get(p2)), min);
            if (l1.get(p1) < l2.get(p2)) {
                p1++;
            } else
                p2++;
        }
        return min;

    }
}