package com.jianqing.interview.leetcode16;

import java.util.HashMap;

/**
 * Created by jianqingsun on 7/9/17.
 */
public class LongestConsecutiveSequence_128 {
    public int longestConsecutive(int[] num) {
        /*
            [100, 1, 3, 200 ,2, 3,4]

            当扫描到2 的时候 map 里有
            < 100, 1> , < 1, 1> , < 3, 1> , < 200, 1>
              2会发现前面的数字的 最长长度是 1， 这样左边界就可以增加了，
              2也会发现后面的数字3 的最长长度是1， 这样右边界也可以增加了
              所以处理完2的时候， 就变成了
               < 1, 3> , < 3, 3> , < 100, 1> , < 200, 1>， <2, 3>
         */
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); // key 是 数组里的number， val 是 window size
        for (int n : num) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                // sum: length of the sequence n is in
                int sum = left + right + 1;
                map.put(n, sum);

                // keep track of the max length
                res = Math.max(res, sum);

                // extend the length to the boundary(s)
                // of the sequence
                // will do nothing if n has no neighbors
                map.put(n - left, sum);
                map.put(n + right, sum);
            } else {
                // duplicates
                continue;
            }
        }
        return res;
    }
}
