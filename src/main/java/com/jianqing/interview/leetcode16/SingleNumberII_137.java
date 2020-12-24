package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 12/14/16.
 */
public class SingleNumberII_137 implements Solution {

    @Override
    public void solution() {

    }

    /*
    现在的解法是比较普通的。因为题目已经说了，除了一个数字以外，
    其他的都出现了3次，如果我们把那个特殊的数剔除，并把剩下的数于每一位来加和的话，每一位上1出现的次数必然都是3的倍数。
    所以，解法就在这里，将每一位数字分解到32个bit上，统计每一个bit上1出现的次数。最后对于每一个bit上1出现的个数对3取模，剩下的就是结果。
     */
    public int singleNumber(int[] A) {
        int[] count = new int[32];
        int result = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < A.length; j++) {
                if (((A[j] >> i) & 1) == 1) {
                    count[i]++;
                }
            }
            result |= ((count[i] % 3) << i);
        }
        return result;
    }


    // 二刷
    public int singleNumber2(int[] A) {
        int res = 0;

        int[] bits = new int[32];

        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < A.length; j++) {
                if (((A[j] >> i) & 1) == 1) {
                    bits[i] ++;
                }
            }
            res |=((bits[i] % 3) << i);
        }
        return res;
    }
}
