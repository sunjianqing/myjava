package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 3/5/18.
 */
public class SumofSquareNumbers_633 {
    public boolean judgeSquareSum(int c) {
        int b = (int)Math.sqrt(c);
        int a = 0;
        while(a <= b){
            int s = a*a + b*b;
            if(s == c){
                return true;
            }
            else if(s > c){
                b--;
            }
            else{
                a++;
            }
        }

        return false;
    }
}
