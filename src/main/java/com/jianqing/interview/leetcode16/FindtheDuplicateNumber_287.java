package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 1/19/18.
 * <p>
 * 方法1： 二分思想， 已知这些数是分布在 1 到 n 的 n+1 个数， 所以， 对 1 到n 算个中间值 mid， 然后loop 目标数组中的数，如果发现小于mid的数目 大于mid，
 * 那说明多出的数在前半部分。否者，多出的那个数在后半部分，这时二分的start 就可以指向mid +1 了
 * 这个方法的时间复杂度 是 nlog(n)
 * <p>
 * 比如 n=10, 现在有11个数， 第一次判断小于 5 = n / 2 的个数
 * 方法2： 这个不容易想， 把数组跟链表联系在一起
 */
public class FindtheDuplicateNumber_287 {

    public int solution(int[] nums) {
        int l = 1;
        int r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            int cnt = 0;
            for( int i = 0; i < nums.length; i++) {
                if(nums[i] <= mid){
                    cnt++;
                }
            }

            if(cnt <= mid){
                // 找另一边
                l = mid + 1;
            }
            else{
                r = mid;
            }
        }

        return l; // l==r
    }

}
