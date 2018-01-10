package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 1/5/18.
 * <p>
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * <p>
 * 用两个变量记录上次能跳的最远距离， 以及现在的最远距离， 每次更新最远距离，每更新一次，就是跳了一步， 如果没法超过上次的最远距离， 就无解
 */
public class JumpGameII_45 {
    public int jump(int[] nums) {
        int n = nums.length;
        int i = 0;
        int curMax = 0;
        int numJump = 0;
        while (curMax < n - 1) {
            int preMax = curMax;
            while (i <= preMax) {
                curMax = Math.max(curMax, i+nums[i]); // 看看能不能更新curMax
                i++;
            }

            numJump++;
            if(preMax == curMax) // 没更新， 不能往前jump了
                return -1;
        }


        return numJump;

    }
}
