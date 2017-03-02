package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 12/19/16.
 */
public class IntegerBreak_343 implements  Solution {
    @Override
    public void solution() {

    }

    public int integerBreak(int n) {
        if(n <3)
            return 1;

        if ( n == 3)
            return 2;

        int res = 1;
        while ( n >= 3){
            if ( n == 4 || n == 2)
                break;
            res *= 3;
            n -=3 ;
        }

        if ( n == 4 || n == 2 ){
            res *= n;
        }

        return res;


    }
}
