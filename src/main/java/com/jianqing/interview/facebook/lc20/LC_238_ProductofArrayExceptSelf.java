package com.jianqing.interview.facebook.lc20;

/**
 * 左右各扫一遍
 * 从右边扫回来的时候，记得用过累乘积
 */
public class LC_238_ProductofArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i-1] * nums[i-1];
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }

        return res;

    }

}
