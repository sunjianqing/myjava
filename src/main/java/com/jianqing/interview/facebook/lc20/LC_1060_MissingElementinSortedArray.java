package com.jianqing.interview.facebook.lc20;

/**
 * Binary Search
 *
 * 注意第一个数不一定是 1
 * 所以求a【index】处 missing了几个number的时候， 得用当前值a[index] - num[0] - index
 * 如果a[index]处missing number 大于k， 就挪right， 否则挪left
 */
public class LC_1060_MissingElementinSortedArray {

    public int missingElement(int[] nums, int k) {
        if (k < 0 || nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;


        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int missing = missingNumber(nums, mid);
            if (missing < k) {
                left = mid;
            }
            else {
               right = mid;
            }
        }

        return  missingNumber(nums, right) < k ? nums[right] + (k - missingNumber(nums, right)) : nums[left] + (k - missingNumber(nums, left));
    }

    int missingNumber(int[] nums, int index) {
        return nums[index] - nums[0] - index;
    }
}
