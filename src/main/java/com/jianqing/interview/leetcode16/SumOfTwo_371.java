package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 11/10/16.
 */
public class SumOfTwo_371 implements Solution {
    @Override
    public void solution() {
        int a = 0;
        int b = 0;

        this.getSum(a, b);
    }

    public int getSum(int a, int b) {
        while (b != 0){
            int carry = (a & b); // Carry is AND of two bits 这一位 是不是进位
            a = a ^ b ; // sum of tw obits is A XOR B 该位上的和
            b = carry << 1 ; //shifts carry to 1 bit to calculate sum 进位往前移， 到下一轮的时候， 当年的位的结果还被保存住
        }

        return a;
    }
}
