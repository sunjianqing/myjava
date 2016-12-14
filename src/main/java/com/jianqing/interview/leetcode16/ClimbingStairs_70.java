package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 12/3/16.
 */
public class ClimbingStairs_70 implements Solution {
    @Override
    public void solution() {

    }

    public int climbStairs(int n) {
        if(n == 0 )
            return 0;
        if(n == 1)
            return 1;
        if (n == 2)
            return 2;

        int res = 0;

        if( n> 2) {
            int[] arr = new int[n+1];
            arr[0] = 0;
            arr[1] = 1;
            arr[2] = 2;
            for ( int i= 3; i <= n; i++){
                arr[i] = arr[i-1] + arr[i-2];
            }
            res = arr[n];
        }

        return res;
    }

    public int climbStairs2(int n) {
        if(n == 0 )
            return 0;
        if(n == 1)
            return 1;
        if (n == 2)
            return 2;

        int res = 0;

        if( n> 2) {
            int c1 = 1;
            int c2 = 2;
            for ( int i= 3; i <= n; i++){
                res = c1 + c2;
                c1 = c2;
                c2 = res;
            }
        }

        return res;
    }
}
