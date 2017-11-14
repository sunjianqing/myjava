package com.jianqing.interview.tmp;

/**
 * Created by jianqing_sun on 10/19/17.
 */
public class B extends A {
    public B() {
        // 这里就没有super()，编译器会自动地添加一个空参数的缺省super构造器，此时如果 父类 A 类中没有空参数的缺省构造器，那就会导致一个编译错误
        System.out.println("Calling B's constructor");
        // super() // 报错！ 如果调用父类的constructor 就得放在第一行
    }

    public B(int a) {
        //如果父类没有不带参数的构造器，并且在子类的构造器中又没有显式地调用父类的构造器，则java编译器将报告错误
        System.out.println("Calling B's constructor");
    }

    public static void main(String[] args) {
        B b = new B(3);

        System.out.println(b);
    }

}

