package com.jianqing.interview.facebook.lc20;

/**
 * DP
 * <p>
 * 对于每个index， 预算一个它左边的可能的k长度的最大sub array的index， 这个可以用presum做
 * 再预算一个它右边的可能的k长度的最大sub array的index
 * <p>
 * 这样再loop遍，固定中间的那个k长度的window，分别利用左边跟右边的预算的值， 就能得到答案
 */
public class LC_689_MaximumSumof3NonOverlappingSubarrays {

    public static void main(String[] args) {
        LC_689_MaximumSumof3NonOverlappingSubarrays lc = new LC_689_MaximumSumof3NonOverlappingSubarrays();
        lc.maxSumOfThreeSubarrays(new int[]{7,13, 20, 19, 19, 2, 10, 1, 1, 19}, 3);
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] res = new int[3];
        if (nums == null || nums.length < k) {
            return res;
        }

        int n = nums.length;
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        int leftMax = preSum[k] - preSum[0];;
        int[] dpLeft = new int[n]; // [0, i) 内，size为k的最大sum的index
        for (int i = k; i < n; i++) {
            if (preSum[i+1] - preSum[i + 1 - k] > leftMax) {
                dpLeft[i] = i + 1 - k;
                leftMax = preSum[i+1] - preSum[i + 1 - k];
            } else {
                dpLeft[i] = dpLeft[i - 1];
            }
        }


        int[] dpRight = new int[n];
        dpRight[n-k] = n - k;
        int rightMax = preSum[n] - preSum[n-k];
        for (int j = n - k - 1; j >= 0; j--) {
            if (preSum[j + k] - preSum[j] >= rightMax) {
                dpRight[j] = j;
                rightMax = preSum[j + k] - preSum[j];
            } else {
                dpRight[j] = dpRight[j + 1];
            }
        }

        int max = 0;
        for (int i = k; i <= n - 2*k; i++) {
            int curSum = 0;
            for (int m = i; m < k + i; m++) {
                curSum += nums[m];
            }

            int leftSum = 0;
            int rightSum = 0;
            for (int m = dpLeft[i-1]; m < dpLeft[i-1] + k; m++) {
                leftSum += nums[m];
            }

            for (int m = dpRight[i+k]; m < dpRight[i+k] + k; m++) {
                rightSum += nums[m];
            }

            if(curSum + leftSum + rightSum > max) {
                res[0] = dpLeft[i-1];
                res[1] = i;
                res[2] = dpRight[i+k];
                max =  curSum + leftSum + rightSum;
            }
        }

        return res;
    }
}
