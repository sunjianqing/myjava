package com.jianqing.interview.tmp;

/**
 * Created by jianqingsun on 10/23/17.
 */
public abstract class AbstractDemo {

    // abstract类中可以有成员变量，但成员变量不能用abstract修饰
    public int age;

    // abstract类中可以有构造方法，抽象类的构造方法不能是抽象方法
    public AbstractDemo(int age) {
        this.age = age;
    }

    public AbstractDemo() {
    }

    // abstract类和abstract方法都不能用final修饰
    public abstract void method();

    // abstract方法不能有方法体，abstract方法不能是private
    abstract int methodReturnInt();

    // 抽象类中可以有非抽象方法
    public int getAge(){
        return age;
    }


}

class AbstractSubClass extends AbstractDemo {

    public AbstractSubClass() {
        super();
    }

    @Override
    public void method() {
        System.out.println("Override parent method()");
        System.out.println(getAge());
    }

    @Override
    int methodReturnInt() {
        return 0;
    }


}
