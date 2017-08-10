package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 1/22/17.
 */
public class SortColors_75 implements Solution {
    @Override
    public void solution() {

    }

    /**
     * count sort 得扫描两边
     * 空间O（1）, 时间O(n) 可以设两个指针一个指向已经排好序的0的序列的后一个点，一个指向已经排好序的2的序列的前一个点， 扫描一遍， 如果是0, 就移动前面的指针
     * 如果是2， 就往前移后面的指针， 如果是1， 继续扫描
     * 也可以建立3个链表， 最后再连起来
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        int i = 0;
        while(i <= right){
            // 遇到0交换到前面
            if(nums[i] == 0){
                swap(nums, i, left);
                left++;
                // 因为左边必定有序，所以可以直接i++
                i++;
                // 遇到2交换到后面
            } else if(nums[i] == 2){
                swap(nums, i, right);
                right--;
                // 换来的数 不知道是几， 所以right-- 后 i不能动
            } else {
                // 遇到1跳过
                i++;
            }
        }
    }

    private void swap(int[] nums, int i1, int i2){
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
}
