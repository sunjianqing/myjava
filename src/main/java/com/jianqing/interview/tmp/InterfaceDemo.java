package com.jianqing.interview.tmp;

/**
 * Created by jianqingsun on 10/23/17.
 */
// 接口中没有构造方法。接口不能用final修饰
public interface InterfaceDemo {
    // 成员变量一定是public static final的，但允许在声明变量时仅指定部分修饰符。但即使没有添加public，static，final中任何一个修饰符，该变量仍然是public static final的
    int len = 1;

    // 成员方法都是public abstract的抽象方法 但即使没有添加public abstract中任何一个修饰符，该成员方法仍然是public abstract的
    int method();

    // 接口中可以定义内部类和内部接口
    class InnerClass {

    }

}

// 一个非抽象类如果实现了某个接口，它必须要实现该接口中声明的所有的抽象方法
class InterfaceImpl implements InterfaceDemo{

    @Override
    public int method() {
        return 0;
    }
}

// 一个抽象类如果实现了某个接口，它可以实现该接口中声明的抽象方法，也可以不实现
abstract class AbstractClassInterfaceDemo implements InterfaceDemo {

}
