package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 3/20/18.
 * <p>
 * 贪心， check 当年的 i 跟 两边是不是0 或者到边界了
 */
public class CanPlaceFlowers_605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }
}
