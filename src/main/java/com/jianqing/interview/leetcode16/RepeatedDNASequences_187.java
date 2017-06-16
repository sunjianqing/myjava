package com.jianqing.interview.leetcode16;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by jianqingsun on 4/23/17.
 */
public class RepeatedDNASequences_187 {
    /* 超时
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();

        if (s == null || s.length() == 0) {
            return res;
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String subStr = s.substring(i, i+10);
            if(set.contains(subStr))
                continue;
            boolean yes = doesContainStr(s.substring(i+1), subStr);
            if(yes){
                set.add(subStr);
            }
        }
        res.addAll(set);
        return res;
    }

    private boolean doesContainStr(String source, String target) {
        int tlen = target.length();

        for( int i = 0 ; i < source.length() - tlen + 1; i++) {
            String s = source.substring(i , i+tlen);
            if(s.hashCode() == target.hashCode())
                return true;
        }
        return false;
    }
    */

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();

        if (s == null || s.length() == 0) {
            return res;
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String subStr = s.substring(i, i+10);
            if(set.contains(subStr)){
                if(!res.contains(subStr))
                    res.add(subStr);
            }
            else{
                set.add(subStr);
            }

        }
        return res;
    }
}
