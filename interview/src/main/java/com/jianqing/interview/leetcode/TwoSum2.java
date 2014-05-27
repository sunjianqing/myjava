package com.jianqing.interview.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jianqsun on 5/26/14.
 */
public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; i++){
            map.put(numbers[i], i);
        }

        for(int i = 0; i < numbers.length; i++){
            int index1 = numbers[i];
            int index2 = target - index1;
            if(map.containsKey(index2) && map.get(index2) > i){
                res[0] = i + 1;
                res[1] =  map.get(index2) + 1 ;
            }
        }
        return res;
    }

    public static void main(String[] args){
        TwoSum2 ts = new TwoSum2();
        ts.twoSum(new int[]{3,2,4}, 6);

    }
}
