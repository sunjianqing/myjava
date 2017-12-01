package com.jianqing.interview.leetcode16;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jianqing_sun on 11/30/17.
 */
public class IsomorphicStrings_205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> smap =  new HashMap<>();
        Map<Character, Character> tmap =  new HashMap<>();


        if(s.isEmpty() && t.isEmpty())
            return true;

        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();

        for(int i = 0; i < schars.length; i++){
            if(!smap.containsKey(schars[i])){
                smap.put(schars[i], tchars[i]);
                if(!tmap.containsKey(tchars[i])){
                    tmap.put(tchars[i], schars[i]);
                }
                else{
                    if(tmap.get(tchars[i]) != schars[i])
                        return false;
                }
            }
            else{
                if(smap.get(schars[i]) == tchars[i])
                    continue;
                else
                    return false;
            }
        }

        return true;

    }

    /*use single map
    if(s == null || s.length() <= 1) return true;
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for(int i = 0 ; i< s.length(); i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(map.containsKey(a)){
                 if(map.get(a).equals(b))
                continue;
                else
                return false;
            }else{
                if(!map.containsValue(b)) // Here ! we have to check value
                map.put(a,b);
                else return false;

            }
        }
        return true;
     */
}
