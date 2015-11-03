package util;

import java.util.PriorityQueue;

/**
 * Created by jianqsun on 5/14/14.
 */
public class PriorityQueueTest {
    public static void main(String[] args){
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(5);
        queue.offer(5);

        queue.offer(3);
        queue.offer(2);
        queue.offer(15);

        System.out.println(queue.poll());
    }
}
