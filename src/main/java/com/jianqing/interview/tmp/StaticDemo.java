package com.jianqing.interview.tmp;

/**
 * Created by jianqingsun on 11/6/17.
 * http://blog.csdn.net/zhouhong1026/article/details/19114589
 */
public class StaticDemo {
    public static String staticStr = "Parent Static variable";

    public static int method(){
        return 1+1;
    }

    public static void main(String[] args) {
        System.out.println(StaticDemoSub.staticStr); // 子类继承了父类的静态属性
        System.out.println(StaticDemoSub2.method()); // 子类继承了父类的静态方法
    }
}

class StaticDemoSub extends StaticDemo {

    public static int method(){

        return 2+2;
    }

}


class StaticDemoSub2 extends StaticDemo {

}


