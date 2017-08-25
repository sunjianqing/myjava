package com.jianqing.interview.facebook;

/**
 * Created by jianqingsun on 7/29/17.
 * 找 sum最大，每个长度都是k 的 三个 subarray。 三个subarray不能有overlap。 举个例子 1,2,1,2,6,7,5,1。k = 2
 * 结果就是
 *
 * [2, 1], [2,6], [7,5]  -> sum = 23

 以上结果就比
   [1,2],[6,7],[5,1] -> sum = 22
 */
public class MaxSumKSubArray {

    // 状态转移方程
    /**
     * 就是包含现在当前 nums[i] 的window里的和 加上 i-k 的情况下的最优解 与 不含有当前当前nums[i] 的最优解  的最大值
     * dp[windowNumber][i] = Math.max(dp[windowNumber][i-1], sumFrom i-k to i + dp[windowNumber-1][i-k])
     *
     */

    // 下面这个可以省空间 ， 但是难懂
    public static int findNWindow(int[] nums, int k, int totalWindowNum){ // 长度都是k 的 n 个window ， 原题n = 3
        int[] lastMaxK = new int[nums.length];
        int[] maxK = new int[nums.length];

        for(int nn = 0; nn < totalWindowNum ; nn++){
            int curSum=0;
            for(int i = nn * k; i < nums.length; i++){
                curSum += nums[i];
                if( i == (nn+1)*k-1 )
                    maxK[i] = curSum;
                if( i >= (nn+1)*k ){
                    curSum -= nums[i-k];
                    maxK[i] = Math.max(lastMaxK[i-k] + curSum, maxK[i-1]);
                }
            }
            int[] t = lastMaxK;
            lastMaxK = maxK;
            maxK = t;
        }

        return lastMaxK[maxK.length-1];
    }

}
