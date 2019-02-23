package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 3/5/18.
 *
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.

 Note: Do not use any built-in library function such as sqrt.

 Example 1:

 Input: 16
 Returns: True

 Example 2:

 Input: 14
 Returns: False

 */
public class ValidPerfectSquare_367 {
    public boolean isPerfectSquare(int num) {
        if(num <=1)
            return true;

        int low = 1;
        int high = num;

        while(low <= high){
            long mid = low + (high - low) / 2;
            if(mid * mid == num)
                return true;

            if(mid*mid > num){
                high =(int) mid -1;
            }
            else {
                low = (int)mid+1;
            }

        }

        return false;
    }
}
