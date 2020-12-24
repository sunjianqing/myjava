package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 1/16/18.
 * <p>
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * , reverse whole array, reverse first part, reverse second part
 * <p>
 * 整个reverse
 * 按照k % n 处劈开， 然后两部分分别reverse
 */
public class RotateArray_189 {

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

}
