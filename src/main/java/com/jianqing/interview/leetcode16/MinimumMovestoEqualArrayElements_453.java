package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 11/28/16.
 */
public class MinimumMovestoEqualArrayElements_453 implements Solution {
    @Override
    public void solution() {
        int[] nums = new int[]{1, 2, 3};
        this.minMoves(nums);
    }

    /*
    正确的解法相当的巧妙，需要换一个角度来看问题，其实给n-1个数字加1，
    效果等同于给那个未被选中的数字减1，比如数组[1，2，3],
    给除去最大值的其他数字加1，变为[2，3，3]，
    我们全体减1，并不影响数字间相对差异，变为[1，2，2]，
    这个结果其实就是原始数组的最大值3自减1，
    那么问题也可能转化为，将所有数字都减小到最小值，这样难度就大大降低了，
    我们只要先找到最小值，然后累加每个数跟最小值之间的差值即可
     */
    public int minMoves(int[] nums) {
        int min = nums[0];
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            cnt += nums[i] - min;
        }

        return cnt;
    }
}
