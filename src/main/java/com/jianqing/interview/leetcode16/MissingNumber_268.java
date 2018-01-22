package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 12/19/16.
 */
public class MissingNumber_268 implements Solution {
    @Override
    public void solution() {

    }

    // 利用a^b^b =a 的性质， n 个数 跟n 个index 做xor， 最后的结果就是missing number
    public int missingNumber2(int[] nums) {

        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ i;
    }


    public int missingNumber(int[] nums) {
        int max = nums[0];

        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            currentSum += nums[i];
        }

        if(max < nums.length){
            // the largest number missing;
            max = nums.length;
        }

        int sum = 0;
        for (int i = 0; i <= max; i++) {
            sum += i;
        }

        return sum - currentSum;

    }
}
