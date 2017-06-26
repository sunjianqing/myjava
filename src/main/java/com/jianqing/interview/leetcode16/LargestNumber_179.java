package com.jianqing.interview.leetcode16;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by jianqing_sun on 6/21/17.
 */
public class LargestNumber_179 {
    public static void main(String[] args) {
        LargestNumber_179 ln = new LargestNumber_179();
        String s = ln.largestNumber(new int[]{9, 5, 34});
        System.out.println(s);
    }

    public String largestNumber(int[] nums) {
        Integer[] ns = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ns[i] = nums[i];
        }

        Arrays.sort(ns, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        //  拍完序 之后 如果第一个数是0，则直接返回0
        if (ns[0] == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (Integer i : ns) {
            sb.append(i);
        }
        return sb.toString();
    }
}
