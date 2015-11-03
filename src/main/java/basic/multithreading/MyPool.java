package com.jianqng.basic.multithreading;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jianqsun on 7/2/14.
 */
public class MyPool {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}
