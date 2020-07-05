package com.jianqing.interview.leetcode_category.double_pointer;

public class LC_633 {

    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        int p1 = 0, p2 = (int) Math.sqrt(c);
        while ( p1 <= p2) {
            int tmp = p1*p1 + p2*p2 ;
            if (tmp == c) {
                return true;
            }
            else if ( tmp > c) {
                p2 --;
            }
            else {
                p1 ++;
            }
        }

        return false;
    }
}
