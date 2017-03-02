package com.jianqing.interview.simple;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by jianqing_sun on 2/10/17.
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {


        PriorityQueueDemo pd = new PriorityQueueDemo();
        pd.demo1();
        pd.demo2();
        pd.demo3();
    }

    public void demo1(){
        System.out.println("Demo primitive type ");
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(2);
        queue.add(3);
        queue.add(1);

        System.out.println(queue.poll()); // 1
        System.out.println(queue.poll()); // 1
        System.out.println(queue.poll()); // 2
    }

    public void demo2(){
        System.out.println("Demo Object type ");

        CompartorObj cpt = new CompartorObj();

        Queue<CompObject> q2 = new PriorityQueue(10, cpt);
        q2.add(new CompObject(1));
        q2.add(new CompObject(2));
        q2.add(new CompObject(2));
        q2.add(new CompObject(1));

        System.out.println(q2.poll().age);
        System.out.println(q2.poll().age);
        System.out.println(q2.poll().age);
    }

    public void demo3(){
        System.out.println("Demo Comparable Object ");

        Queue<ComparableObj> q2 = new PriorityQueue(10);
        q2.add(new ComparableObj(1));
        q2.add(new ComparableObj(32));
        q2.add(new ComparableObj(12));
        q2.add(new ComparableObj(1));

        System.out.println(q2.poll().age);
        System.out.println(q2.poll().age);
        System.out.println(q2.poll().age);
    }


    class CompartorObj implements Comparator<CompObject> {

        @Override
        public int compare(CompObject o1, CompObject o2) {
            return o1.age - o2.age;
        }
    }

    class ComparableObj implements Comparable{

        int age;

        public ComparableObj(int age) {
            this.age = age;
        }

        @Override
        public int compareTo(Object obj) {
            return age - ((ComparableObj)obj).age;
        }
    }

    class CompObject{
        int age;

        public CompObject(int age) {
            this.age = age;
        }
    }

}
