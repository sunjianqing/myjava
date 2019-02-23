package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 3/5/18.
 *
 * Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.

 Example 1:
 Input: 5
 Output: True
 Explanation: 1 * 1 + 2 * 2 = 5

 Example 2:
 Input: 3
 Output: False

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
