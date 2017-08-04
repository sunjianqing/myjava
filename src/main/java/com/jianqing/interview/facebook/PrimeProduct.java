package com.jianqing.interview.facebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by jianqingsun on 7/27/17.
 */
public class PrimeProduct {

    public List<Integer> Solution(int[] primes) {
        List<Integer> res = new ArrayList<>();

        Set<Integer> nums = new HashSet<>();

        for(int num: primes){
            nums.add(num);
        }

        while(nums.size() !=0) {
            res.addAll(nums);

            Set<Integer> tmp = new HashSet<>();
            for(int num: nums) {
                for(int factor: primes){
                    if(num % factor != 0 ){ // 不是factor 的倍数
                        tmp.add(num * factor);
                    }
                }
            }
            nums = tmp;
        }

        return res;

    }

}
