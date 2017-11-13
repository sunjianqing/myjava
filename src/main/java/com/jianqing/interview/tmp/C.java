package com.jianqing.interview.tmp;

/**
 * Created by jianqing_sun on 10/19/17.
 */
public class C extends B {

    public static void main(String[] args) {

        C c = new C();
        B b = (B)c;

        B bb = new B();
        C cc = (C)b; // 编译能过

        //cc = b; // 编译不过
        //cc = (B)c; // 编译不过
    }

}
