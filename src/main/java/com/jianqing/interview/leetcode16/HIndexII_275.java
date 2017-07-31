package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 7/12/17.
 * [2, 3, 5, 8, 28]
 *
 * 答案是3
 * 根据 H-Index 定义， citation >= 3 的文章有4篇， 如果是5需要， citations >= 5 的文章 至少是5， 2符合定义（有5篇 的citation >= 2，
 * 但不是最大的， 所以 3 是答案
 *
 * 注： H-index 的数值， 可能不是citation array 里的数， 例如 [1,1,1,25,25] ， H-Index = 2 有两篇文章的citation > 2
 */
public class HIndexII_275 {

    public static void main(String[] args) {
        HIndexII_275 hi = new HIndexII_275();
        int i = hi.hIndex(new int[]{1, 1, 1, 25, 25});
        System.out.println(i);
    }

    public int hIndex(int[] citations) {

        int n = citations.length;
        if(n == 0) return 0;
        int min = 0, max = citations.length - 1;
        while(min <= max){
            int mid = (min + max) / 2;
            // 如果该点是有效的H指数， 说明后面的文章数大于当前citation number, 则最大H指数一定在右边
            if(citations[mid] < n - mid){
                min = mid + 1;
                // 否则最大H指数在左边
            } else {
                max = mid - 1;
            }
        }
        // n - min是min点的H指数
        return n - min;
    }
}
