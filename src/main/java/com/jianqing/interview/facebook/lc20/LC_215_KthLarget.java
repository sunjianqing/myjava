package com.jianqing.interview.facebook.lc20;

import java.util.PriorityQueue;

/**
 * Method 1 : min heap with size k
 * Method 2 : quick select， 找到pivot index 正好是k 的时候 （desending order）， 或者ascending order 的时候 pivot index是 size - k +1
 */

public class LC_215_KthLarget {

    public static void main(String[] args) {
        LC_215_KthLarget lc = new LC_215_KthLarget();
//        int kthLargest = lc.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        int kthLargest = lc.findKthLargestQuickSelect(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println(kthLargest);
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0 || k < 1 || k > nums.length) {
            return Integer.MIN_VALUE;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i1 - i2);

        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }

    public int findKthLargestQuickSelect(int[] nums, int k) {
        if (nums.length == 0 || k < 1 || k > nums.length) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;
        int targetK = nums.length - k + 1;
        while (left <= right) {
            int pivotIndex = partition(nums, left, right);
            if (pivotIndex + 1 == targetK) {
                return nums[pivotIndex];
            } else if (targetK < pivotIndex + 1) {
                right = pivotIndex - 1;
            } else {
                left = pivotIndex + 1;
            }
        }

        return 0;
    }

    // 需要背诵
    private int partition(int[] nums, int left, int right) {
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

    private void swap(int[] nums, int p1, int p2) {
        int tmp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = tmp;
    }

}
