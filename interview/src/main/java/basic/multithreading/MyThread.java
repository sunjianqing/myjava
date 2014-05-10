package basic.multithreading;

import static java.lang.Thread.*;

/**
 * Created by jianqsun on 3/7/14.
 */
public class MyThread implements Runnable {
    private String m_name;

    MyThread(String name){
        this.m_name = name;
    }

    @Override
    public void run(){
        for(int i = 1 ; i<=5 ; i++){
            System.out.println(m_name+":" + i);
            yield();
        }
    }
}
