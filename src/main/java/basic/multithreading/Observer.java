package basic.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jianqsun on 2/7/14.
 */
public class Observer {
    public ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<Integer, Integer>();

    public static void main(String[] args){
        Observer obs = new Observer();
        int i = 1;
        List<Thread> workerThreads = new ArrayList<Thread>();
        while(i <= 10 ){
            Thread t = new Thread(new Work(obs, i), "WorkThread" + String.valueOf(i));
            t.start();
            workerThreads.add(t);
            i++;
        }
        for(Thread t : workerThreads ){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Done");
        return;
    }

    public synchronized void recordCnt(){
        for(Map.Entry<Integer,Integer> entry : this.concurrentHashMap.entrySet()){
            int hostId = entry.getKey();
            int value = entry.getValue();
            System.out.print("Current Thread:" + Thread.currentThread().getName());
            System.out.print(" Host Id:" + String.valueOf(hostId));
            System.out.println(" Value :" + String.valueOf(value));
        }
    }
}
