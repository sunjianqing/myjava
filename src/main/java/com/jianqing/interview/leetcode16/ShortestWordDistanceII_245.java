package com.jianqing.interview.leetcode16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jianqing_sun on 3/12/18.
 * 如果 ShortestWordDistance I 中， 两个单词一样咋办 ， 用II 中同样的方法
 */
public class ShortestWordDistanceII_245 {
    public int shortestDistance(String[] words, String word1, String word2) {
        int n = Integer.MAX_VALUE ;
        Map<String, List<Integer>> map = new HashMap<>();

        for(int i = 0 ; i < words.length; i++){
            String s = words[i];
            if(s.equals(word1) || s.equals(word2)){
                List<Integer> values = map.getOrDefault(s, new ArrayList<Integer>());
                values.add(i);
                map.put(s, values);
            }
        }

        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word1);

        int p1 = 0, p2 = 0;

        while(p1 < l1.size() && p2 < l2.size()){
                if(p1 != p2){
                    n = Math.min(n, Math.abs(p1 - p2));
                }

            if(l1.get(p1) > l2.get(p2))
                p2++;
            else
                p1++;
        }


        return n;

    }
}
