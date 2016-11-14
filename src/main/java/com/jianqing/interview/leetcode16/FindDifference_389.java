package com.jianqing.interview.leetcode16;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jianqingsun on 11/12/16.
 */
public class FindDifference_389 implements Solution {
    public void solution() {

    }

    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }
            else
                map.put(c, 1);
        }

        for(char  c : t.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }
            else
                map.put(c, 1);
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() % 2 != 0)
                return entry.getKey().charValue();
        }

        return 0;
    }

    // 可以使用位操作Bit Manipulation来做，利用异或的性质，
    // 相同位返回0，这样相同的字符都抵消了，剩下的就是后加的那个字符
    public char findTheDifference2(String s , String t){
        char res = 0;
        for (char c : s.toCharArray()) res ^= c;
        for (char c : t.toCharArray()) res ^= c;
        return res;
    }
}
