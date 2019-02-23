package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 12/15/16.
 *
 * For example, given [1,2,3,4], return [24,12,8,6].
 *
 */
public class ProductofArrayExceptSelf_238 implements Solution {
    @Override
    public void solution() {

    }

    /**
     * 左右各扫一遍， 记录每个数， 前面/后面的乘积
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] leftToright = new int[nums.length];
        int[] rightToleft = new int[nums.length];



        int productBeforeMe = 1;
        for ( int i = 0; i < nums.length   ; i++){
            leftToright[i] = productBeforeMe;
            productBeforeMe *= nums[i];
        }

        int productAfterMe = 1;
        for ( int j = nums.length -1 ; j >=0 ; j--){
            rightToleft[j] = productAfterMe;
            productAfterMe *= nums[j];
        }


        //每个位置相乘
        int[] res = new int[nums.length];
        for ( int i = 0; i< res.length ; i++){
            res[i] = leftToright[i] * rightToleft[i];
        }

        return res;
    }
}
