package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 1/19/18.
 *
 * 根据提示， 只需更新每个区间的first 元素 (+inc)， 跟last + 1 元素 (-inc)， 然后用累积和, 算出最后数组
 * 为什么要在 last+1 的值 -inc ？因为累积和，一路加过去， 就多加了， 所以在last+1 处要减去这一轮的值
 * 比如 【1，3，2】
 * 只更新index 1 和 index 1+3 = 4 就行
 * 初始数组就变成了 0,2,0,0,-2,0
 */
public class RangeAddition_370 {
    public int[] getModifiedArray(int length, int[][] updates){
        int[] res = new int[length+1];

        for(int[] update : updates){
            int start = update[0];
            int end = update[1];
            int inc = update[2];
            res[start] = res[start] + inc;
            res[end + 1] = res[end +1] - inc;
        }

        int sum = 0;
        int[] re = new int[length];
        for(int i = 0; i < res.length; i++) {
            sum += res[i];
            re[i] = sum;
        }

        return re;
    }
}
