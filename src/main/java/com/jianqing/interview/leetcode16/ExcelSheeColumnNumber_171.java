package com.jianqing.interview.leetcode16;

import java.util.HashMap;

/**
 * Created by jianqingsun on 11/28/16.
 */
public class ExcelSheeColumnNumber_171 implements Solution {
    @Override
    public void solution() {

    }

    public int titleToNumber(String s) {
        if(s==null || s.length() == 0){
            throw new IllegalArgumentException("Input is not valid!");
        }

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char c = 'A';
        for(int i=1; i<=26; i++){
            map.put(c, i);
            c += 1;
        }

        int result = 0;
        int i = s.length()-1;
        int t = 0;
        while(i >= 0){
            char curr = s.charAt(i);
            result = result + (int) Math.pow(26, t) * map.get(curr);
            t++;
            i--;
        }

        return result;
    }
}
