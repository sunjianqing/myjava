package com.jianqing.interview.classic;

import java.util.Random;

/**
 * Created by jianqingsun on 7/8/17.
 */
public class RandomClass {
    public static void main(String[] args) {
        Random r = new Random();

        int i = r.nextInt();
        System.out.println(i);

        int j = r.nextInt(10);
        System.out.println(j);
    }
}
