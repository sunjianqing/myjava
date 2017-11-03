package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 10/16/17.
 *
 * 左右各扫一遍， 记录最大值，
 * 最后再扫一遍， 算水量
 */
public class TrapWater_42 {

    public int trap(int[] height) {
        if(height.length < 3)
            return 0;
        int res = 0;
        int n = height.length;

        int[] left = new int[n];
        int[] right = new int[n];
        int leftMax = height[0];
        int rightMax = height[n-1];

        for(int i = 1 ; i < n ; i++) {
            if(height[i] < leftMax){
                left[i] = leftMax;
            }
            else{
                leftMax = height[i];
            }
        }

        for(int j = n-2 ; j > 0 ; j--) {
            if(height[j] < rightMax){
                right[j] = rightMax;
            }
            else{
                rightMax = height[j];
            }
        }

        for(int k = 1 ; k < n -1 ; k++) {
            if(left[k] != 0 && right[k] !=0){
                res += Math.min(left[k], right[k]) - height[k];
            }
        }

        return res;
    }

}
