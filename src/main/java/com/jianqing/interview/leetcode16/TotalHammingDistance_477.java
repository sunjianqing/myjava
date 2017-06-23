package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 6/20/17.
 */
public class TotalHammingDistance_477 {
    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int total = 0;
        for (int i = 0; i < nums.length - 1; i++)
            for (int j = i + 1; j < nums.length; j++) {
                total += findHDist(nums[i], nums[j]);
            }
        return total;
    }

    private int findHDist(int a, int b) {
        int c = a ^ b;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((c & (1 << i)) > 0) {
                res++;
            }

        }
        return res;
    }

    // Other
    /*
        通过最简单的比较所有对数的Hamming Distance发现，如果一对数的某移bit 位， 是0 和 1， 那么它们就会贡献1个距离，所以题目变成了
        统计所有32位上的1的个数， 算Hamming Distance的时候， 就是每一位上的1 的 个数乘以总数减去这个个数 （相当于从两堆数里 m, n ，选一对的可能性, 有m * n 种可能）， 最后加起来就行。
     */
    public int solution(int[] nums) {
        int n = 31;
        int len = nums.length;
        int[] countOfOnes = new int[n];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < n; j++) {
                countOfOnes[j] += (nums[i] >> j) & 1;
            }
        }
        int sum = 0;
        for (int count: countOfOnes) {
            sum += count * (len - count);
        }
        return sum;
    }
}
