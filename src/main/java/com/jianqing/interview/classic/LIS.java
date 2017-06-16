package com.jianqing.interview.classic;

/**
 * Created by jianqing_sun on 6/15/17.
 * <p>
 * longest contiguous increasing subsequence
 * 最长连续递增子序列
 *
 * longest increasing subsequence
 * 最长递增子序列
 *
 */
public class LIS {

    public static void main(String[] args) {
        LIS l = new LIS();
        System.out.println(l.resolveLCIS(new int[]{1, 2, 3, 4, 5}));
        System.out.println(l.resolveLCIS(new int[]{1, 2, 1, 4, 5}));
        System.out.println(l.resolveLCIS(new int[]{5, 3, 3, 2, 1}));
        System.out.println(l.resolveLCIS(new int[]{1, 1, 1}));
    }

    public int resolveLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res = 1;
        int currentLen = 1;
        int startIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentLen++;
            } else {
                if(currentLen > res){
                    startIndex = i - currentLen+1;
                    res = currentLen;
                }

                currentLen = 1;
            }
        }
        if(currentLen > res){
            startIndex = nums.length - currentLen;
        }
        System.out.println("start index is " + startIndex);
        return Math.max(res, currentLen);
    }


}
