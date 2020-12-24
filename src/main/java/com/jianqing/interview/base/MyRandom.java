package com.jianqing.interview.base;

import java.util.ArrayList;
import java.util.Random;

public class MyRandom {
    public static void main(String[] args) {
        // 左闭右开
        System.out.println("Math.random()=" + Math.random());// 结果是个double类型的值，区间为[0.0,1.0）
        int num = (int) (Math.random() * 3); // 注意不要写成(int)Math.random()*3，这个结果为0，因为先执行了强制转换
        System.out.println("num=" + num);


        /**
         * 下面Random()的两种构造方法：
         * 　　Random()：创建一个新的随机数生成器。
         * 　　Random(long seed)：使用单个 long 种子创建一个新的随机数生成器。
         *
         * 我们可以在构造Random对象的时候指定种子（这里指定种子有何作用，请接着往下看），如：Random r1 = new Random(20);
         * 或者默认当前系统时间的毫秒数作为种子数:Random r1 = new Random();
         * 需要说明的是：你在创建一个Random对象的时候可以给定任意一个合法的种子数，种子数只是随机算法的起源数字，和生成的随机数的区间没有任何关系。
         */

        // 案例2
        // 对于种子相同的Random对象，生成的随机数序列是一样的。
        Random ran1 = new Random(8);
        System.out.println("使用种子为8的Random对象生成[0,10)内随机整数序列: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(ran1.nextInt(10) + " ");
        }
        System.out.println();
        Random ran2 = new Random(8);
        System.out.println("使用另一个种子为8的Random对象生成[0,10)内随机整数序列: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(ran2.nextInt(10) + " ");
        }
        /**
         * 输出结果为：
         *
         * 使用种子为8的Random对象生成[0,10)内随机整数序列:
         * 4 6 0 1 2 8 1 1 3 0
         * 使用另一个种子为8的Random对象生成[0,10)内随机整数序列:
         * 4 6 0 1 2 8 1 1 3 0
         *
         */

        // 案例3
        // 在没带参数构造函数生成的Random对象的种子缺省是当前系统时间的毫秒数。
        Random r3 = new Random();
        System.out.println();
        System.out.println("使用种子缺省是当前系统时间的毫秒数的Random对象生成[0,10)内随机整数序列");
        for (int i = 0; i < 10; i++) {
            System.out.print(r3.nextInt(10) + " ");
        }
        /**
         * 输出结果为：
         *
         * 使用种子缺省是当前系统时间的毫秒数的Random对象生成[0,10)内随机整数序列
         * 1 6 7 6 7 4 3 7 8 3
         *
         */

        // 另外，直接使用Random无法避免生成重复的数字，如果需要生成不重复的随机数序列，需要借助数组和集合类
        ArrayList list = new MyRandom().getDiffNO(10);
        System.out.println();
        System.out.println("产生的n个不同的随机数：" + list);



        // random(1)

        Random r4 = new Random();
        int i = r4.nextInt(1);
        System.out.println(i);

    }

    /**
     * 生成n个不同的随机数，且随机数区间为[0,10)
     *
     * @param n
     * @return
     */
    public ArrayList getDiffNO(int n) {
        // 生成 [0-n) 个不重复的随机数
        // list 用来保存这些随机数
        ArrayList list = new ArrayList();
        Random rand = new Random();
        boolean[] bool = new boolean[n];
        int num = 0;
        for (int i = 0; i < n; i++) {
            do {
                // 如果产生的数相同继续循环
                num = rand.nextInt(n);
            } while (bool[num]);
            bool[num] = true;
            list.add(num);
        }
        return list;
    }

}
