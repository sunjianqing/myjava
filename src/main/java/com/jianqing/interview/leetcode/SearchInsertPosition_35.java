package com.jianqing.interview.leetcode;

/**
 * Created by jianqing_sun on 1/3/18.
 */
public class SearchInsertPosition_35 {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }

        int l = 0;
        int r = nums.length - 1;

        while (l + 1 < r) {
            int mid = l + (r -l)/2;
            if(nums[mid] == target)
                return mid;

            if(nums[mid] > target){
                r = mid;
            }
            else{
                l = mid;
            }
        }

        if(nums[l] == target){
            return l;
        }
        else if(nums[r] == target){
           return r;
        }
        else if(target < nums[l]){
            return l - 1 == -1 ? 0 : l-1;
        }
        else if(target > nums[l] && target < nums[r]){
            return l+1 ;
        }
        else {
            return r+1;
        }

    }

    public int searchInsert2(int[] A, int target) {
        int low = 0, high = A.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(A[mid] == target) return mid;
            else if(A[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return low;
    }

}
