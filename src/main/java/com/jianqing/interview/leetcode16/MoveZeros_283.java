package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 11/13/16.
 */
public class MoveZeros_283 implements Solution {
    @Override
    public void solution() {

    }

    // 把非0 的数 往前移动， 然后剩余的全部置0
    public void moveZeroes(int[] nums) {
        int zeroIndex = 0, i = 0;

        // 将非0数字都尽可能向前排，但是没交换
        for (; i< nums.length ; i ++){
            if (nums[i] != 0 ){
                nums[zeroIndex] = nums[i];
                zeroIndex ++;
            }
        }

        // 将剩余的都置0
        for(;zeroIndex<nums.length; zeroIndex++){
            nums[zeroIndex] = 0;
        }

    }

    // 双指针, 发现非0， 交换
    public void moveZeroes2(int[] nums){

    }
}
