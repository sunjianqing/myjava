package com.jianqing.interview.tmp;

/**
 * Created by jianqing_sun on 10/19/17.
 */
public class A {
    int a;

    int A(int a) { // 这里A(int a) 是个方法， 不是constructor
        this.a = a;
        return 0;
    }

    A(){
        System.out.println("Calling A constructor");
    }

    A(int a) {
        this.a = a;
    }

}


