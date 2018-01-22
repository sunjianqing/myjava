package com.jianqing.interview.language;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jianqingsun on 1/20/18.
 */
public class Java8New {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        int[] array = list.stream().mapToInt(i -> i).toArray();
    }
}
