package com.jianqing.interview.leetcode_category.double_pointer;

/**
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 *
 * 从 nums1 , nums2 的尾部开始往前推
 */
public class LC_88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = m - 1, i2 = n - 1;
        int mergeIndex = m + n - 1;
        while (i1 >= 0 || i2 >= 0) {
            if (i1 < 0) {
                nums1[mergeIndex--] = nums2[i2--];
            }
            else if (i2 <0) {
                nums1[mergeIndex--] = nums1[i1--];
            }
            else if (nums1[i1] > nums2[i2]) {
                nums1[mergeIndex--] = nums1[i1--];
            }
            else {
                nums1[mergeIndex--] = nums2[i2--];
            }
        }

    }


}
