package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 10/15/17.
 * <p>
 * 申请一个长度为n的数组uglyNumbers，用于从小到大顺序存储n个丑数，数组中的首项为1，即第一个丑数为1
 * <p>
 * 设置三个变量idx2、idx3、idx5存储下标，初始值都为0
 * 每次如果是index 的上一个ugly number 乘以当前的 factor (2, 3, 或 5 ) 使乘积 最小， 就更新那个index， 让index加1
 * （找出数组uglyNumbers[idx2]*2、uglyNumbers[idx3]*3、uglyNumbers[idx5]*5的最小值，
 * 最小值即为下一个丑数，同时更新最小值对应的下标，如果多个数字同时为最小值，则它们的下标都要更新）
 * <p>
 * 比如 1*2， 1*3， 1*5 选 idx2， 这样2 就变成了第二个ugly number ， 然后idx2++
 * 下一轮， 就是 2*2, 1*3, 1*5, 选idx3, 这样乘积3 就成了下一个ugly number， 然后idx3++
 * 下一路， 就是 2*2，2*3, 1*5, 选idx2， 这样4 就是下一个ugly number， 然后idx2++
 */
public class UglyNumberII_264 {
    public int nthUglyNumber(int n) {
        int[] numbers = new int[n];
        numbers[0] = 1;
        int idx2 = 0, idx3 = 0, idx5 = 0;

        int counter = 1;
        while (counter < n) {
            int nextNum = Math.min(Math.min(numbers[idx2] * 2, numbers[idx3] * 3), numbers[idx5] * 5);
            numbers[counter] = nextNum;

            if(nextNum == numbers[idx2] * 2){
                idx2++;
            }

            if(nextNum == numbers[idx3] * 3){
                idx3++;
            }

            if(nextNum == numbers[idx5] * 5){
                idx5++;
            }

            counter++;


        }

        return numbers[n-1];
    }
}
