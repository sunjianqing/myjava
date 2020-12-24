package com.jianqing.interview.facebook.lc20;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀和
 *
 * 如果前面有 sum1 % k == 0, 后面又发现了 sum2 % k == 0 , 那说明 sum1 , sum2 之间的数肯定是k 的倍数 ！！！
 *
 * corner case 很烦
 * [0,0]  0
 * [0]  0
 */
public class LC_523_ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = nums[i] + preSum[i - 1];
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);  // 用来解决 [0,0]  0

        for (int i = 0; i < preSum.length; i++) {

            int res = preSum[i];
            if (k != 0) {
                res = preSum[i] % k;
            }
            if (map.containsKey(res) && (i - map.get(res)) > 1) {
                return true;
            }

            if (!map.containsKey(res)) {
                map.put(res, i);
            }
        }

        return false;
    }

}
