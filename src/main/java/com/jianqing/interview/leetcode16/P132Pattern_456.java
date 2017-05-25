package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 5/23/17.
 */
public class P132Pattern_456 {

    public boolean find132pattern(int[] nums) {
        // 找到一个window 【start, end] nums[start] 最小， nums[end] 最大， 中间的数都是不符合规则的，然后扫描剩下的， 剩下的数里还有可能比start小的， 所以要保留为新的window 的start
        if (nums == null || nums.length < 2)
            return false;

        int start = 0;
        int i = 0, j = 0, k = 0;
        int n = nums.length;
        int end = 0;
        while (start < n) {
            // 找window的左边， 找最小的
            for (i = start + 1; i < n; i++) {
                if (nums[i] < nums[start]) {
                    start = i;
                } else
                    break;
            }
            if (i == n)
                return false;

            end = i;

            // 找window 的右边， 只要升序， 就可以一直更新右边界， 因为这个数一定不符合规则
            for (j = end+1; j < n; j++) {
                if(nums[j] > nums[end]){
                    end = j;
                }
                else
                    break;
            }

            if( j == n)
                return false;

            // 在剩下的里面找符合规则的，找到就返回， 没有就来下轮
            for ( k = j; k < n; k++){
                if(nums[k] > nums[start] && nums[k] < nums[end])
                    return true;
            }

            start = j;
        }

        return false;
    }
}
