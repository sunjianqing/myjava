package com.jianqing.interview.simple;

import java.util.PriorityQueue;

/**
 * Created by jianqingsun on 1/26/17.
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.add(3);
        pq.add(1);
        pq.add(5);
        pq.add(10);
        pq.add(1);

        System.out.println("peek() " + pq.peek());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());


    }

    
}
