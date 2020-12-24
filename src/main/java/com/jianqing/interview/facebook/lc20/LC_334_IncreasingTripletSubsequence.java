package com.jianqing.interview.facebook.lc20;

/**
 * 一遍扫过去记录并更新第一大， 第二大的数， 然后发现第三个， 就可以return true
 */
public class LC_334_IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int n1 = Integer.MAX_VALUE;
        int n2 = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= n1) {
                n1 = nums[i];
            }
            else if (nums[i] <= n2) {
                n2 = nums[i];
            }
            else
                return true;
        }

        return false;
    }

}
