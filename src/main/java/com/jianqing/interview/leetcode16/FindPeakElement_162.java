package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 1/24/17.
 */
public class FindPeakElement_162 implements Solution {

    public static void main(String[] args) {
        FindPeakElement_162 f = new FindPeakElement_162();
        f.solution();
    }

    @Override
    public void solution() {
        this.findPeakElement(new int[]{2, 1});
    }

    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;

        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] < nums[mid - 1]) {
                end = mid ;
            } else if (nums[mid] < nums[mid + 1]) {
                start = mid ;
            } else {
                return mid;
            }
        }

        return nums[start] > nums[end] ? start : end;
    }
}
