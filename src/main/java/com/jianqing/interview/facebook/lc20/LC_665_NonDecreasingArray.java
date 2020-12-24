package com.jianqing.interview.facebook.lc20;

/**
 *
 * 注意i 要跟 i-2 比较
 *
 * 比如 i = 3 时
 * 1364
 * 要改成1344 ，继续找
 * 1362
 * 要改成1366 继续找
 */
public class LC_665_NonDecreasingArray {

    public boolean checkPossibility(int[] nums) {

        int times = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                times ++;
                if (i-2 < 0 || nums[i-2] <= nums[i]) nums[i-1] = nums[i];  //modify nums[i-1] of a priority
                else nums[i] = nums[i-1];
            }

            if (times > 1)  return false;

        }

        return true;

    }
}
