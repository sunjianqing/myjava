package com.jianqing.interview.facebook.lc20;

/*
  Given an unsorted integer array nums, find the smallest missing positive integer.
  给一个未排序数组， 找第一个缺少的正整数


    Example 1:

  Input: nums = [3,4,-1,1]
  Output: 2

  Example 2:
   Input: nums = [7,8,9,11,12]
    Output: 1

  n = nums.length
  所有数应该都在[1, n+1]

  方法1： Hash
  方法2： 利用num里的数字去更新一个长度n的boolean 数组, 因为如果缺数儿， 肯定是缺的n以内的
  方法3： 挺难懂的， O(n) time, O(1) space

 */

public class LC_41_FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        return method2(nums);
    }

    public int method2(int[] nums) {
        int n = nums.length;

        boolean[] flags = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0 && nums[i] < n + 1) {
                flags[nums[i] - 1] = true;
            }
        }

        // find the first false
        for (int i = 0; i < n; i++) {
            if(flags[i] == false) {
                return i + 1;
            }
        }

        return n + 1;
    }

    public int method3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <=0) {
                nums[i] = Integer.MAX_VALUE; // 标记成 不需要考虑
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]); // 因为前面的正数可能把后面的 位置改成负数了 比如 [-2，3，2，1，0，4] 处理到3的时候， 可能会把2那个位置改成-2
            if (num <= nums.length) {
                nums[num - 1] = - Math.abs(nums[num - 1]);
            }
        }

        for (int i =0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

}
