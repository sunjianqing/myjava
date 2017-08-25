package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 8/2/17.
 */
public class OneEditDistance_161 {

    public static void main(String[] args) {
        OneEditDistance_161 oed = new OneEditDistance_161();
        boolean oneEditDistance = oed.isOneEditDistance("abce", "acbce");
        System.out.println(oneEditDistance);

    }
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
                    return s.substring(i,s.length()).equals(t.substring(i+1, t.length()));
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
