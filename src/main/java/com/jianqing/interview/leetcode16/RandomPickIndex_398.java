package com.jianqing.interview.leetcode16;

import java.util.Random;

/**
 * Created by jianqingsun on 1/3/17.
 */
public class RandomPickIndex_398 {
    public static void main(String[] args) {
        Random r = new Random();
        System.out.println(r.nextInt(1));
        System.out.println(r.nextInt(1));
        System.out.println(r.nextInt(1));
        System.out.println(r.nextInt(1));

    }

    public int[] nums;
    Random rand = new Random();

    public void RandomPickIndex_398(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }

    /*
        详细解释
        http://hongzheng.me/leetcode/leetcode-398-random-pick-index/
        水塘抽样
        用水塘size 为1， 水塘里的东西总会等概率的被替换， 所以最后返回的水塘里的东西就是等概率的
        
     */
    public int pick(int target) {
        int res = -1;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                cnt++;
                int r = rand.nextInt(cnt);
                res = r == 0 ? i : res; // if 0 , replace res with index
            }
        }

        return res;
    }
}
