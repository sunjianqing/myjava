package com.jianqing.interview.leetcode16;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by jianqingsun on 7/22/17.
 *
 * str = "aabbcc", k = 3

 Result: "abcabc"

 The same letters are at least distance 3 from each other.

 */
public class RearrangeStringkDistanceApart_358 {

    public String rearrangeString(String str, int k) {
        if(k==0)
            return str;

        //initialize the counter for each character
        final HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c, 1);
            }
        }

        //sort the chars by frequency
        PriorityQueue<Character> queue = new PriorityQueue<Character>(10, new Comparator<Character>(){

            @Override
            public int compare(Character c1, Character c2) {
                if(map.get(c2).intValue()!=map.get(c1).intValue()){
                    return map.get(c2) - map.get(c1);
                }else{
                    return c1.compareTo(c2);
                }
            }
        });


        for(char c: map.keySet())
            queue.offer(c);

        StringBuilder sb = new StringBuilder();

        int len = str.length();

        while(!queue.isEmpty()){

            int cnt = Math.min(k, len);
            ArrayList<Character> temp = new ArrayList<Character>();

            for(int i=0; i<cnt; i++){
                if(queue.isEmpty()) // 要是还没run 完循环， queue 就为空了， 就退出了
                    return "";

                char c = queue.poll();
                sb.append(String.valueOf(c));

                map.put(c, map.get(c)-1);

                if(map.get(c)>0){
                    temp.add(c);
                }

                len--;
            }

            for(char c: temp)
                queue.offer(c);
        }

        return sb.toString();
    }
}
