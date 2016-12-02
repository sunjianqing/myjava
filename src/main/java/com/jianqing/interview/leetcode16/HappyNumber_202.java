package com.jianqing.interview.leetcode16;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jianqing_sun on 12/1/16.
 */
public class HappyNumber_202 implements Solution {

    public static void main(String[] args) {
        HappyNumber_202 hn = new HappyNumber_202();
        hn.solution();
    }
    @Override
    public void solution() {
        this.isHappy(7);
    }

    public boolean isHappy(int n) {
        if(n == 1)
            return true;
        if ( n == 0)
            return false;
        Set<Integer> set = new HashSet<>();

        while(n != 1){
            int sum = 0;
            while(n > 9){
                int c = n % 10 ;
                sum += c*c;
                n = n / 10;
            }
            sum += n * n;
            if(set.contains(sum))
                return false;
            else{
                n = sum;
                set.add(sum);
            }
        }
        return true;
    }
}
