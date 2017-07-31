package com.jianqing.interview.leetcode16;

import java.util.HashMap;

/**
 * Created by jianqing_sun on 6/26/17.
 *
 * 拿分子除以分母，整数位保留， 然后重复"余数乘以10再除以分母"，记录每次的分子和出现的index，再次遇到，就是找到了循环部分
 *
 */
public class FractiontoRecurringDecimal_166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0)
            return "0";

        StringBuilder sb = new StringBuilder();
        // "+" or "-"
        sb.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        // integral part
        sb.append( num / den);

        if(num % den == 0)
            return sb.toString();
        else
            sb.append(".");

        num %= den;
        // fractional part
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, sb.length());
        while(num !=0){
            num *= 10;
            sb.append(num/den);
            num %= den;

            if(map.containsKey(num)){
                int index = map.get(num);
                sb.insert(index, "(");
                sb.append(")");
                break;
            }
            else{
                map.put(num, sb.length());
            }
        }

        return sb.toString();

    }
}
