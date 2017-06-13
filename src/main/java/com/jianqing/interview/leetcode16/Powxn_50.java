package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 6/4/17.
 */
public class Powxn_50 {
    public double myPow(double x, int n) {
        if(n < 0) {
           return 1 / pow(x, -n);
        }
        else {
            return pow(x, n);
        }

    }

    public double pow(double x, int n){
        if( n  == 0)
            return 1;

        int h = n / 2;
        double half = pow(x, h );
        if ( n % 2 == 0){
            return half * half;
        }
        else
            return x * half * half;

    }
}
