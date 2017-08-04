package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 7/15/17.
 */
public class HammingDistance_461 {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y ;
        int cnt = 0;
        for ( int i = 0 ; i < 32; i ++){
            cnt += ( xor >> i ) & 1;
        }

        return cnt;
    }

}
