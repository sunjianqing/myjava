package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 7/17/17.
 *
 * http://blog.csdn.net/mebiuw/article/details/52724293
 * 二分查找  start = 一堆数中最大的， end = sum of all numbers
 */
public class SplitArrayLargestSum_410 {
    public int splitArray(int[] nums, int m) {
        int max = 0; long sum = 0;
        for (int num : nums) {
            max = Math.max(num, max);
            sum += num;
        }
        if (m == 1) return (int)sum;
        //binary search
        long l = max; long r = sum;
        while (l <= r) {
            long mid = (l + r)/ 2;
            if (valid(mid, nums, m)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int)l; // 返回left
    }
    public boolean valid(long target, int[] nums, int m) {
        int count = 1;
        long total = 0;
        //是否有多余m个片段or区间，大于给定值的max的，如果有了，那么就不合法了，因为这样划分就不止m个，及max太小
        for(int num : nums) {
            total += num;
            if (total > target) {
                total = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
}
