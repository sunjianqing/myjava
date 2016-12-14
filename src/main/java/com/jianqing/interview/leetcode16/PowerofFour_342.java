package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 12/7/16.
 */
public class PowerofFour_342 implements Solution {
    @Override
    public void solution() {

    }

    public boolean isPowerOfFour(int num) {
        return num > 0 && ( 0 == (num & (num - 1))) && (num & 0x55555555) == num;
    }

    public boolean isPowerOfFour2(int num) {
        return num > 0 && (0 ==(num & (num - 1))) && (num - 1) % 3 == 0;
    }
}
