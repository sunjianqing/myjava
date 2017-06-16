package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 4/25/17.
 */
public class IntegerReplacement_397 {

    public int integerReplacement(int n) {

        return helper(n);


    }

    private int helper( long n ){
        if ( n == 1)
            return 0;
        if ( n == 2)
            return 1;

        if( n % 2 == 0)
            return helper(n/2) + 1;
        else{
            return 2 + Math.min( helper( (n+1) / 2 ), helper( (n -1) /2 ) );
        }
    }

}
