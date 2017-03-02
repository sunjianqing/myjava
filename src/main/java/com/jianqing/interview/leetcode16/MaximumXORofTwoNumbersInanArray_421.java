package com.jianqing.interview.leetcode16;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jianqingsun on 12/28/16.
 */
public class MaximumXORofTwoNumbersInanArray_421 implements Solution {

    @Override
    public void solution() {

    }

    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {

            /*
            算法 第一部分
            生成所有num 可能的前缀
            方法是 ， 跟mask 一直做 与
            比如， 如果mask 是 1100， 如果有数字左数第一位是1， 第二位是0， set里就会有1000
            如果有数字左数第一位是0， 第二位是1， set里就会有0100
            如果有数字是1101， 那么set里就会有1100

             */
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }

            /*
             算法 第二部分
             一直试探max，随着外层循环i的减小一位位的试
             比如，一开始 试 1000 ， 发现有可能有两个数字使最高位为1， 就保留这一位
             为什么有两个数字会使最高位为1 ？
             根据公式 tmp ^ x = prefix  => x^prefix = tmp , 这说明 x 跟 prefix 代表的某一个数 异或， 能使最高位变成1
             这就说明最终结果里， 这一位是被设置的。
             继续试探的话， 下一轮可能是1100 ，如果还能找到前缀 能使 最高的两位都被置1， 那就保留1100
             如果不能， max 还是原来的1000
             再试左数第三位， 如果找到了， 那就把max 变成 1010
             一直从高位试下去， 就能找到最大值
             */
            int tmp = max | (1 << i);
            for (int prefix : set) {
                if (set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }


}


