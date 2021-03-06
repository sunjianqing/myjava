package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 8/15/17.
 * 题目要merge numbs 2 到 1 里
 * merge nums2 into nums1
 *
 * 从后往前merge
 */
public class MergeSortedArray_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        int i = m - 1;
        int j = n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }

    }
}
