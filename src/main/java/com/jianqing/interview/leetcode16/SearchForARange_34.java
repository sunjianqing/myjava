package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 11/7/17.
 * <p>
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * <p>
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */
public class SearchForARange_34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int start = 0;
        int end = nums.length - 1;

        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;

        // find left most
        int left = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                left = mid;
                end = mid - 1;
                continue;
            }

            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if(left == -1)
            return res;
        else {
            if(nums[start] == target)
                res[0] = start;
            else  if(nums[end] == target)
                res[0] = end;
            else
                res[0] = left;
        }

        // find right most
        int right = -1;
        start = 0;
        end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                right = mid;
                start = mid + 1;
                continue;
            }

            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if(right == -1)
            return res;
        else {
            if(nums[end] == target)
                res[1] = end;
            else  if(nums[start] == target)
                res[1] = start;
            else
                res[1] = right;
        }

        return res;
    }
}
