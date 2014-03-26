package basic.multithreading;

/**
 * Created by jianqsun on 3/7/14.
 */
public class TestMyThread {
    public static void main(String[] args){
        Thread[] threads = {
                new Thread(new MyThread("Thread 1")),
                new Thread(new MyThread("Thread 2")),
                new Thread(new MyThread("Thread 3")),
        };
        for(Thread t: threads){
            t.start();
        }
    }
}
