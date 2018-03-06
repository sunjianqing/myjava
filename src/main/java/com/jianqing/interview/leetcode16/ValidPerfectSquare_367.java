package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 3/5/18.
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
