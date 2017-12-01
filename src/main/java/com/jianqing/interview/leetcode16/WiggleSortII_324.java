package com.jianqing.interview.leetcode16;

import java.util.Arrays;

/**
 * Created by jianqingsun on 6/11/17.
 *
 */
public class WiggleSortII_324 {

    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length == 1){
            return;
        }

        int[] res = new int[nums.length];

        int mid = (nums.length - 1 ) /  2 ; // 减1 保证从mid+1 到最后end 的数目一定 <= 半数

        Arrays.sort(nums);
        int start = mid, end = nums.length - 1;
        int i = 0;
        while (start > 0){
            res[i++] = nums[start];
            res[i++] = nums[end];
            start--;
            end--;
        }

        res[i++] = nums[start];
        if(end > mid )
            res[i++] = nums[end];

        for( i = 0 ;  i < nums.length; i++){
            nums[i] = res[i];
        }
    }
}
