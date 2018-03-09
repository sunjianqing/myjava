package com.jianqing.interview.language;

/**
 * Created by jianqingsun on 2/9/18.
 */
public class ClassLoaderDemo {

    {
        System.out.println("Instance block ");
    }

    public static void main(String[] args) {
        ClassLoaderDemo demo = new ClassLoaderDemo();
    }

    public ClassLoaderDemo() {
        System.out.println("Constructor block");
    }


}
