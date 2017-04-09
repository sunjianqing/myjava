package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 3/30/17.
 */
public class BitwiseANDofNumbersRange_201 {
    /**
        向右移动m和n，直到相等
     */
    public int rangeBitwiseAnd(int m, int n) {

        int i = 0;
        while ( m != n){
            m = m >> 1;
            n = n >> 1;
            i++;
        }

        return m << i;

    }
}
