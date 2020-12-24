package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 6/26/17.
 * 比如
 * 47/3 可以拆成 2^3*3 + 2^2*3 + 2^1*3+ 2^0*3 = 24+12+6+3
 * 结果就是       8    +  4    +  2   +  1  = 15
 *
 * n 往右移动k位，就是n*2^k
 */
public class DivideTwoIntegers_29 {

    public int divide(int dividend, int divisor) {
        //handle special cases
        if (divisor == 0) return Integer.MAX_VALUE;
        if (divisor == -1 && dividend == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;

        //get positive values
        long pDividend = Math.abs((long) dividend);
        long pDivisor = Math.abs((long) divisor);

        int result = 0;
        while (pDividend >= pDivisor) {
            //calculate number of left shifts
            int numShift = 0;
            while (pDividend >= (pDivisor << numShift)) {
                numShift++;
            }

            //dividend minus the largest shifted divisor
            result += 1 << (numShift - 1);
            pDividend -= (pDivisor << (numShift - 1));
        }

        /**
         * Find sign could be like this
         *
         * int sign = (dividend < 0) ^ (diviso < 0)
         */
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            return result;
        } else {
            return -result;
        }
    }
}
