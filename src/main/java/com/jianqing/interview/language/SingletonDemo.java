package com.jianqing.interview.language;

/**
 * Created by jianqingsun on 2/9/18.
 */
public class SingletonDemo {
    private static SingletonDemo instance = new SingletonDemo();

    private SingletonDemo(){
        System.out.println("Hello world .... ");
    }
}
