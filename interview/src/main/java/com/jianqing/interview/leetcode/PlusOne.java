package com.jianqing.interview.leetcode;

import java.util.LinkedList;
import java.util.List;


/**
 * Created by jianqsun on 6/25/14.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        int i = digits.length - 1 ;
        int carry = 1;
        while(i>=0){
            int sum = digits[i] + carry;
            list.offerFirst(sum%10);
            carry = sum / 10;
            i--;
        }
        if(carry > 0 )
            list.offerFirst(carry);
        return convert(list);
    }

    public int[] convert(List<Integer> list){
        int[] arr = new int[list.size()];
        int i = 0;
        for(Integer num: list){
            arr[i++] = num;
        }
        return arr;
    }
}
