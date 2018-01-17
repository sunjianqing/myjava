package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 1/16/18.
 *
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 , reverse whole array, reverse first part, reverse second part
 */
public class RotateArray_189 {

    public void rotate(int[] nums, int k) {

        k %= nums.length;
        if(k == 0)
            return;

        int i=0;
        int j=nums.length -1;
        while( i < j ){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }

        i = 0;
        j = k-1;
        while( i < j ){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }

        i = k;
        j = nums.length -1;
        while( i < j ){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }

        return;
    }
}
