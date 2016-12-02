package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 12/1/16.
 */
public class PowerofTwo_231 implements Solution {
    @Override
    public void solution() {

    }

    public boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;
        if(n == 1)
            return true;

        if(n % 2 == 0)
            return isPowerOfTwo(n/2);

        return false;
    }

    public boolean isPowerOfTwo2(int n){
        return ((n & (n-1))==0 && n>0);
    }

    /*
    每次判断最低位是否为1，然后向右移位，最后统计1的个数即可判断是否是2的次方数
     */
    public boolean isPowerOfTwo3(int n){
        int cnt = 0;
        while (n > 0){
            cnt += n & 1;
            n >>=1;
        }

        return cnt == 1;
    }
}
