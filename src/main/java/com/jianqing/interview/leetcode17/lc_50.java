package com.jianqing.interview.leetcode17;

/**
 * Created by jianqingsun on 11/11/17.
 * <p>
 * Pow(x, n)
 */
public class lc_50 {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;

        if (n == 1)
            return x;

        if (n % 2 == 0)
            return myPow(x, n / 2) * myPow(x, n / 2);
        else
            return myPow(x, n / 2) * myPow(x, n / 2) * x;
    }
}
