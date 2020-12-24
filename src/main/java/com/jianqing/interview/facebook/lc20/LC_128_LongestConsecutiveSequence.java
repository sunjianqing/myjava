package com.jianqing.interview.facebook.lc20;

import java.util.*;

public class LC_128_LongestConsecutiveSequence {
    /*
            [100, 1, 3, 200 ,2, 3,4]

            当扫描到2 的时候 map 里有
            < 100, 1> , < 1, 1> , < 3, 1> , < 200, 1>
              2会发现前面的数字的 最长长度是 1， 这样左边界就可以增加了，
              2也会发现后面的数字3 的最长长度是1， 这样右边界也可以增加了
              所以处理完2的时候， 就变成了
               < 1, 3> , < 3, 3> , < 100, 1> , < 200, 1>， <2, 3>
    */
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int res = 1;

        Set<Integer> allNums = new HashSet<Integer>();

        for (int n: nums){
            allNums.add(n);
        }

        for (int n : allNums) {
            int left = map.getOrDefault(n - 1, 0);
            int right = map.getOrDefault(n + 1, 0);

            int sum = left + right + 1;
            res = Math.max(res, sum);

            map.put(n - left, sum);
            map.put(n + right, sum);
        }
        return res;
    }
}
