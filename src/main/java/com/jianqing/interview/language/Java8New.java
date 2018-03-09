package com.jianqing.interview.language;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by jianqingsun on 1/20/18.
 */
public class Java8New {
    public static void main(String[] args) {
        // 把list 转成 array
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        int[] array = list.stream().mapToInt(i -> i).toArray();


        // String 多了join 方法
        String joinedStr = String.join(",", "" + list);
        System.out.println(joinedStr);

        Collections.reverseOrder();

    }
}
