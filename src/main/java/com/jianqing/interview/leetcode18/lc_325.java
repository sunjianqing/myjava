package com.jianqing.interview.leetcode18;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 最大连续子序列 等于 k
 * Maximum Size Subarray Sum Equals k
 *
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k.
 * If there isn't one, return 0 instead.
 *
 * Given nums = [1, -1, 5, -2, 3], k = 3,
 * return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
 *
 * n^2 解法  就是 pre sum 比较所有可能
 *
 * n 解法 用个 hashmap 存 每一种 presum 的值， 并且第二次看到这个值的时候不用存， 因为先出现的 肯定可以组成更长的 。
 * 比如 [1,-1,5,-5], hashmap 里已经存过 0 -> 1, 当碰到-5 的时候， 就不用存 0 -> 3
 */
public class lc_325 {

    public static void main(String[] args) {
        int[] a = new int[]{1, -1, 5, -2, 3};


        int res = lc_325.maxSubArrayLen(a, 3);
        System.out.println(res);

        a = new int[]{1, -1, 5, -2, -3};
        res = lc_325.maxSubArrayLen(a, 0);
        System.out.println(res);

        res = lc_325.maxSubArrayLen2(a, 0);
        System.out.println(res);

    }

    public static int maxSubArrayLen(int[] nums, int k) {
        int len = nums.length;

        int[] sum = new int[len+1];

        Arrays.fill(sum, 0);

        for(int i = 1; i <= len; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        int res = 0;

        for(int i = 0; i < len; i++){
            for( int j = 0; j < i; j++){
                int diff = sum[i+1] - sum[j];
                if(diff == k){
                    res = Math.max(res, i+1-j);
                }
            }
        }

        return res;

    }

    public static int maxSubArrayLen2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int res = 0;

        for( int i = 0; i < nums.length; i++) {

            sum += nums[i];

            // == k 的情况， 也可以初始 map(0-> -1),
            if(sum == k) {
                res = Math.max(res, i+1);
            }

            int diff = sum - k;


            if(map.containsKey(diff)){
                res = Math.max(res, i-map.get(diff));
            }

            map.putIfAbsent(sum, i);
        }

        return res;
    }
}
