package com.jianqing.interview.basic;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by jianqing_sun on 1/22/18.
 */
public class HeapDemo {

    public static void main(String[] args) {
        HeapDemo demo = new HeapDemo();
        demo.fixedSizeHeap(2);

    }
    public void minHeap(){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    }

    public void maxHeap(){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void fixedSizeHeap(int capacity){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(capacity);

        minHeap.add(1);
        minHeap.add(2);
        minHeap.add(3);

        // 大于capacity了， 就丢最小的出来
        if(minHeap.size() > capacity){
            Integer element = minHeap.poll();
            System.out.println(element);
        }

    }

}
