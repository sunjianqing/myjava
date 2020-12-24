package com.jianqing.interview.leetcode18;

import java.util.*;

/**
 * 桶排序
 * 或者
 * PriorityQueue
 */

public class lc_347 {
    public static void main(String[] args) {
        lc_347 lc = new lc_347();
        int[] nums = new int[]{1,1,1,2,2,3};

        List<Integer> integers = lc.topKFrequent(nums, 2);

        System.out.println(integers);

        PriorityQueue<Number> queue = new PriorityQueue(4, new Comparator<Number>(){

            @Override
            public int compare(Number o1, Number o2) {
                return o1.freq - o2.freq; // DEFAULT 
//                if(o1.freq < o2.freq){
//                    return -1;
//                }
//                else if(o1.freq == o2.freq){
//                    return 0;
//                }
//                else{
//                    return 1;
//                }

            }
        });

        queue.add(new Number(2, 2));
        queue.add(new Number(1, 1));
        queue.add(new Number(3, 3));


        System.out.println(queue.peek().freq);



    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();

        if(k < 0 || nums == null || nums.length == 0){
            return res;
        }

        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int n : nums){
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Number> queue = new PriorityQueue(k, new Comparator<Number>(){

            @Override
            public int compare(Number o1, Number o2) {
                return o2.freq - o1.freq;
            }
        });


        for(int key : freqMap.keySet()){
            queue.add(new Number(freqMap.get(key), key));
        }


        for(int i=0;i<k;i++){
            res.add(queue.poll().key);
        }
        return res;
    }
}

class Number {
    public int freq;
    public int key;

    public Number(int freq, int key) {
        this.freq = freq;
        this.key = key;
    }
}
