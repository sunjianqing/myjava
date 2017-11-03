package com.jianqing.interview.tmp;

import java.util.*;

/**
 * Created by jianqingsun on 8/3/17.
 */
public class MyTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hafe");
        list.add("acbe");
        list.add("abc");

        Collections.sort(list);
        for (String s : list) {
            System.out.println(s + " ");
        }

        PriorityQueue<String> queue = new PriorityQueue<String>(11, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });

        Queue<Integer> que = new LinkedList<>();


        StringBuilder sb = new StringBuilder();
        sb.insert(0, "1");
        sb.insert(0,"2");

        System.out.println(sb.toString());

        int divisor = 3;
        int dividend = 7;
        System.out.println((float)( divisor / dividend));

    }

}
