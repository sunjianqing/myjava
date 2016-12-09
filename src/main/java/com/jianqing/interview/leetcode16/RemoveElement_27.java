package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 12/8/16.
 */
public class RemoveElement_27 implements  Solution {
    @Override
    public void solution() {
    }

    public int removeElement(int[] nums, int val) {
        if ( nums == null || nums.length == 0 )
            return 0;

        int i = 0 , j= nums.length-1;
        int res = 0;
        while ( i <= j){
            if(nums[i] == val){
                if(nums[j] != val){
                    nums[i] = nums[j];
                    nums[j] = val;
                }
                j--;
            }
            else{
                i++;
                res++; // 每次不相等， res 加1
            }
        }

        return res;
    }

    // This is good
    /*
    使用两个游标i，j，遍历数组，如果碰到了value，使用j记录位置，同时递增i，
    直到下一个非value出现，将此时i对应的值复制到j的位置上，
    增加j，重复上述过程直到遍历结束。这时候j就是新的数组长度
     */
    public int removeElement2(int[] nums, int val){
        int i = 0, j=0;

        for(i = 0; i < nums.length; i++) {
            if(nums[i] == val) {
                continue;
            }

            nums[j] = nums[i];
            j++;
        }

        return j;
    }
}
