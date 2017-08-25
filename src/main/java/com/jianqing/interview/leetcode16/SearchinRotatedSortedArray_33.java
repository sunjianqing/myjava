package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 4/7/17.
 * http://www.cnblogs.com/ireneyanglan/p/4890848.html
 * 总有一半是排好序的 ， 排好序的条件 是 比较 两端 的值 跟target 大小
 *
 * 1. red line (start < median)

 　　1.1 target < median && target >= start　　-> [ start --- mid ]

 　　1.2 else　　　　　　　　　　　　　　　　　    -> [ mid --- end ]

 2. green line (start > median)

 　　2.1 target > median && target <= end　　 -> [ mid --- end ]

 　　2.2 else　　　　　　　　　　　　　　　　　　-> [ start -- mid ]

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
    public int search2(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;
        int mid;

        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[start] < A[mid]) {
                // situation 1, red line
                if (A[start] <= target && target <= A[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                // situation 2, green line
                if (A[mid] <= target && target <= A[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        } // while

        if (A[start] == target) {
            return start;
        }
        if (A[end] == target) {
            return end;
        }
        return -1;
    }


}
