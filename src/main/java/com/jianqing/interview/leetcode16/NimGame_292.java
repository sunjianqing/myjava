package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 11/9/16.
 */
public class NimGame_292 implements Solution {
    @Override
    public void solution() {
        this.canWinNim(23);
    }

    public boolean canWinNim(int n) {
        if (n % 4 == 0)
            return false;
        else
            return true;
    }
}
