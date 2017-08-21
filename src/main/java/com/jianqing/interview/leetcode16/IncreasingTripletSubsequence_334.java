package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 1/11/17.
 */
public class IncreasingTripletSubsequence_334 implements Solution {
    @Override
    public void solution() {

    }

    /**
     * loop 维持第一 第二小的 数
     */
    public boolean increasingTriplet(int[] nums) {
        if (nums.length <= 2)
            return false;

        int n1 = Integer.MAX_VALUE;
        int n2 = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n <= n1)
                n1 = n;
            else if (n <= n2)
                n2 = n;
            else
                return true;
        }

        return false;

    }

}
