package com.jianqing.interview.facebook.lc20;

/**
 * Find Minimum in Rotated Sorted Array
 *
 * 原理是
 * rotated array 可以被分成 4个部分
 * ---Increasing---Max---Min---Increasing
 *
 * 如果原数组nums[0] 比 nums[len-1] 小，第一个就是解
 *
 * 每次mid落在某个位置，总有一部分是有序的 比如
 * mid < right ,就去左边找， right = mid
 *
 */
public class LC_153_FindMinimuminRotatedSortedArray {

    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

}
