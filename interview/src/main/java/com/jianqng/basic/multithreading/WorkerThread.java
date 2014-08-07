package com.jianqng.basic.multithreading;

/**
 * Created by jianqsun on 7/21/14.
 */
public class WorkerThread implements Runnable{
    public WorkerThread(String s) {
        Thread.currentThread().setName(s);
    }

    @Override
     public void run() {

    }
}
