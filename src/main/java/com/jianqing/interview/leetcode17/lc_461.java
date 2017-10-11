package com.jianqing.interview.leetcode17;

/**
 * Created by jianqing_sun on 10/9/17.
 * <p>
 * Hamming Distance
 */
public class lc_461 {

    public int hammingDistance(int x, int y) {
        int dist = 0 ;
        for (int i = 0; i < 32; i++) {
            int xbit = x & 1 ;
            int ybit = y & 1;
            dist +=  xbit ^ ybit;
            x = x >> 1;
            y = y >> 1;
        }

        return dist;
    }
}
