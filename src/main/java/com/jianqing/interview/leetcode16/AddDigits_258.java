package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 11/11/16.
 *
 * Digital Root
 * https://en.wikipedia.org/wiki/Digital_root
 */
public class AddDigits_258 implements Solution {
    public void solution() {

    }

    public int addDigits(int n) {
        int sum = 0;
        while ( true ){
            int digit = n % 10;
            sum += digit;
            n = n / 10;
            if ( n == 0){
                if (sum < 10)
                    break;
                else{
                    n = sum;
                    sum = 0;
                }
            }
        }
        return sum;

    }

    public int addDigits2(int num){
        return (num - 1) % 9 + 1;
    }
}
