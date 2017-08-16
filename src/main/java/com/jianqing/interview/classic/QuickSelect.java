package com.jianqing.interview.classic;

/**
 * Created by jianqing_sun on 7/20/17.
 */
public class QuickSelect {

    public static void main(String[] args) {
        QuickSelect qs = new QuickSelect();
        int k = 2;
        int[] nums =  new int[]{1, 4, 6, 2, 3, 12, 9, 4};
        int n = qs.kthLargestElement(k, nums);
        System.out.println(n);
        for(int i = 0; i < k; i++){
            System.out.print(nums[i]);
        }
    }

    //*********Recursive***********

    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (k <= 0) {
            return 0;
        }
        // 找第几大的 ， 就是 nums.length - k + 1 , 第几小的 就是 k
        return helper(nums, 0, nums.length - 1, k );

    }

    public int helper(int[] nums, int l, int r, int k) {
        if (l == r) {
            return nums[l];
        }
        int position = partition(nums, l, r);
        if (position + 1 == k) {
            return nums[position];
        } else if (position + 1 < k) {
            return helper(nums, position + 1, r, k);
        } else {
            return helper(nums, l, position - 1, k);
        }
    }

    public int partition(int[] nums, int l, int r) {
        // 初始化左右指针和pivot
        int left = l, right = r;
        int pivot = nums[left];

        // 进行partition
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }

        // 返还pivot点到数组里面
        nums[left] = pivot;
        return left;
    }


}
