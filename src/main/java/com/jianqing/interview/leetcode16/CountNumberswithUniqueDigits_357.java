package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 12/16/16.
 */
public class CountNumberswithUniqueDigits_357 implements Solution {
    @Override
    public void solution() {

    }

    /*
        如果数有k位，计算k位数下，可能的没有重复数字的组合数， 然后相加
        例如
        1位数 ： 10个可能
        2位数： 9*9
        3位数： 9*9*8
        k位数: 9*9*8*...*(9-k+2)
     */
    public int countNumbersWithUniqueDigits(int n) {

        if(n == 0 )
            return 1 ;

        int sum = 10;

        for ( int i = 2 ; i <= n; i++){
            int tmp = 9;

            for ( int p = 2 ; p <= i ; p++){
                tmp = tmp * (9 - p + 2 );
                if ( 9-p + 2 == 0){
                    tmp = 0;
                    break;
                }
            }

            sum += tmp;

        }

        return sum;
    }
}
