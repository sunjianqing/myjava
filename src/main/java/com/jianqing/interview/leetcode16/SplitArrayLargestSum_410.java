package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 7/17/17.
 *
 * http://blog.csdn.net/mebiuw/article/details/52724293
 * 二分查找  start = 一堆数中最大的， end = sum of all numbers
 * 在解空间上进行二分查找， 二分查找可以保证scan 到最好的界限
 * 比如 【4，3，4，4，5】， m = 2  解空间在 [5,20] 之间
 * 第一次试 (5+20) / 2 = 12 , 发现可以切（所有切分的 各个数 之和 都小于12），下次可以尝试比12再小 "最大值" ， 这时， 就减少 right 指针
 * 这样就变成了从[5,11] 里求解
 *
 * 最后发现到10 不行， 说明无论怎么切， subarray 的和都大于10， 但是11 可以， subarray 的 sum <= 11, 所以 11 就是解了
 *
 * code 里 退出 while 只有在l比r 大1 的情况， 那个时候已经到了最有的tight bound，总有一种情况work的。
 * 最后return l 正好cover 两种情况
 * 1，就是 r = mid -1 , 使得r 比 l 小了1 ， 就直接返回l 了
 * 2. 就是 l = mid +1 , 使得 l 比 r 大了1， 说明这轮不valid ，返回上次
 * http://blog.csdn.net/u014688145/article/details/69525838
 *
 *
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
