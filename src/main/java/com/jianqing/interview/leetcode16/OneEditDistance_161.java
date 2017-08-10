package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 8/2/17.
 */
public class OneEditDistance_161 {
    public boolean isOneEditDistance(String s, String t){

        int diff = Math.abs(s.length() - t.length());
        if( diff >= 2)
            return false;

        if(diff == 1){
            if(s.length() > t.length()){
                // swap s and t
                String tmp = s;
                s = t;
                t = tmp;
            }

            int i = 0;

            while(i < s.length()){
                if(s.charAt(i) != t.charAt(i)){
                    return s.charAt(i) == t.charAt(i+1);
                }
                i++;
            }

            return true;

        }
        else{
            // diff == 0
            int diffcnt = 0;
            for( int i = 0 ; i < s.length(); i++){
                if(s.charAt(i) != t.charAt(i))
                    diffcnt++;
            }
            return diffcnt == 1;
        }

    }
}
