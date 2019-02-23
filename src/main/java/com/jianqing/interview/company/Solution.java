package com.jianqing.interview.company;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jianqingsun on 3/9/18.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        Map<Integer, Integer> m1 =  new HashMap<>();

        Map<Integer, Integer> m2 =  new HashMap<>();

        //     vectorX = (3, 0, 0, 0, 1)

        //     vectorY = (3, 2, 0, 0, 1)
        m1.put(0,3);
        m1.put(4,1);

        m2.put(0,3);
        m2.put(1,2);
        m2.put(4,1);
        m2.put(6,2);

        Map<Integer, Integer> m = s.Solution2(m1, m2);

        for(Map.Entry<Integer, Integer> entry: m.entrySet()){
            System.out.println(" index " + entry.getKey() + " value " + entry.getValue());
        }
    }

    public Map<Integer, Integer> Solution2(Map<Integer, Integer> v1m, Map<Integer, Integer> v2m){


        for(Map.Entry<Integer, Integer> entry: v1m.entrySet()){
            if(v2m.containsKey(entry.getKey()))
                v2m.put(entry.getKey(),  v2m.get(entry.getKey()) +  entry.getValue());
            else
                v2m.put(entry.getKey(),entry.getValue());
        }

        return v2m;

    }

    public int[] Solution(int[] v1, int[] v2){
        if(v1.length != v2.length){
            throw new RuntimeException();

        }
        int n = v1.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            if(v1[i] !=0){
                map.put(i, v1[i]);
            }
        }


        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            v2[entry.getKey()] += entry.getValue();
        }

        return v2;

    }


}
