package com.jianqing.interview.language;

import java.util.List;

/**
 * Created by jianqingsun on 2/9/18.
 */
public class ReflectionDemo {
    public static void main(String[] args) {

        try {
            Object o = Class.forName("com.jianqing.interview.language.Person").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

class Person implements Comparable{

    String name;
    List<String> contacts;
    int age;

    public Person(String name, List<String> contacts, int age) {
        this.name = name;
        this.contacts = contacts;
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
