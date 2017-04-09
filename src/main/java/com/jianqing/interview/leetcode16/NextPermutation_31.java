package com.jianqing.interview.leetcode16;

import java.util.Arrays;

/**
 * Created by jianqing_sun on 3/7/17.
 */
public class NextPermutation_31 {


    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 4, 2, 1};
        NextPermutation_31 question = new NextPermutation_31();
        question.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        int[] nums2 = { 6, 5, 4, 2, 1};
        question.nextPermutation(nums2);
        System.out.println(Arrays.toString(nums2));

        int[] nums3 = { 1,1};
        question.nextPermutation(nums3);
        System.out.println(Arrays.toString(nums3));

    }

    public void nextPermutation(int[] nums) {

        int i = nums.length - 2;
        // find the first index which is less than next
        for (; i >= 0; ) {
            if (nums[i] >= nums[i + 1]) {
                i--;
            } else {
                break;
            }
        }

        if(i<0){
            reverse(nums, 0, nums.length-1);
            return;
        }

        // find the first index which is greater than num[i], 要被交换的那个数
        int j = nums.length - 1;
        for (; j >= 0; ) {
            if (nums[j] > nums[i]) {
                break;
            } else {
                j--;
            }
        }

        swap(nums, i , j);
        reverse(nums, i+1, nums.length-1);

    }

    public void swap(int[] nums, int i , int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int[] nums, int start, int end){
        while(start < end ){
            swap(nums, start, end);
            start ++;
            end--;
        }
    }
}
