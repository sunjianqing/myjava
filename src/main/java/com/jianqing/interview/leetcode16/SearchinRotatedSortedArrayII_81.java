package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 4/7/17.
 * 不能通过判断 nums[left] 与 nums[mid] 的大小来决定那边有序， 比如
 * 要在
 * 1，1，1，3，1
 * 和 1,3,1,1,1
 * 里找3
 * 第一次循环 nums[mid] = 1 , 它跟nums[left] 相等， 这样就不能决定下步是在左边search 还是在右边search
 * 对于  1，1，1，3，1  target 3 会在右边
 * 对于  1,3,1,1,1  target 3 会在左边
 * 所以， 只能移动left 一位继续找
 */
public class SearchinRotatedSortedArrayII_81 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        return binarySearch(nums, target, 0, nums.length - 1);

    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        if (left > right)
            return -1;

        int mid = left + (right - left) / 2;
        if (nums[mid] == target)
            return mid;

        if (nums[left] < nums[mid]) {
            if (target >= nums[left] && target < nums[mid]) {
                return binarySearch(nums, target, left, mid - 1);
            } else
                return binarySearch(nums, target, mid + 1, right);
        } else if (nums[left] > nums[mid]) {
            // right part is sorted
            if (target > nums[mid] && target <= nums[right]) {
                return binarySearch(nums, target, mid + 1, right);
            } else
                return binarySearch(nums, target, left, mid - 1);
        } else {
            left++;
            return binarySearch(nums, target, left, right);
        }
    }
}
