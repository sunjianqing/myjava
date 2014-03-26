package basic.multithreading;

/**
 * Created by jianqsun on 2/7/14.
 */
public class Work implements Runnable {

    private Observer observer;
    private int hostId;


    public Work(Observer observer, int hostId){
        this.observer = observer;
        this.hostId = hostId;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 100){
            observer.concurrentHashMap.put(this.hostId,i);
            i += 10;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            observer.recordCnt();
        }


    }
}
