package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 4/7/17.
 */
public class SearchinRotatedSortedArray_33 {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        return binarySearch(nums, target, 0, nums.length - 1);

    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        if (left > right)
            return -1;

        int mid = left + (right - left) / 2;
        if(nums[mid] == target)
            return mid;

        if (nums[left] <= nums[mid] ) { // 注意， 这里一定得是 <=
            // left part is sorted
            if (target >= nums[left] && target < nums[mid] ){
                return binarySearch(nums, target, left, mid -1 );
            }
            else
                return  binarySearch(nums, target, mid+1 , right);
        }
        else{
            // right part is sorted
            if( target > nums[mid] && target <= nums[right]){
                return binarySearch(nums, target, mid+1 , right);
            }
            else
                return binarySearch(nums, target, left, mid -1 );
        }
    }

    // iterative solution
    public int search2(int[] nums, int target) {
        return -1;
    }


}
