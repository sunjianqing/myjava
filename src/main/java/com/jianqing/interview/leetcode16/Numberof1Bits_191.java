package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 12/3/16.
 */
public class Numberof1Bits_191 implements  Solution {
    @Override
    public void solution() {
        int input =  147483648;
        hammingWeight(input);
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0;
        while ( n !=0 ){
            if ( (n & 1) == 1)
                cnt++;
            n = n>>>1;
        }
        Integer i = 123;

        return cnt;
        /*
        我们来看看它的移位过程(可以通过其结果换算成二进制进行对比)：

        5换算成二进制： 0000 0000 0000 0000 0000 0000 0000 0101
        5右移3位后结果为0，0的二进制为： 0000 0000 0000 0000 0000 0000 0000 0000        // (用0进行补位)

         -5换算成二进制： 1111 1111 1111 1111 1111 1111 1111 1011
        -5右移3位后结果为-1，-1的二进制为：
        1111 1111 1111 1111 1111 1111 1111 1111   // (用1进行补位)
        -5无符号右移3位后的结果 536870911 换算成二进制：
        0001 1111 1111 1111 1111 1111 1111 1111   // (用0进行补位)


        通过其结果转换成二进制后，我们可以发现，正数右移，高位用0补，负数右移，高位用1补，当负数使用无符号右移时，用0进行部位(自然而然的，就由负数变成了正数了)

        注意：笔者在这里说的是右移，高位补位的情况。正数或者负数左移，低位都是用0补。(自行测试)
         */
    }
}
