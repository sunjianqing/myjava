package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 1/22/17.
 */
public class ContainerWithMostWater_11 {
    /**
     Solution 1:
     记录比较所有可能 a[i][j] = (j - i ) * min (w[i], w[j])
     Solution 2:
     通过两个“指针”，分别指向头和尾。

     分别往中间移动，
     当 “左指针” 指向的线段长度小于“右指针”指向的线段长度，则移动 “左指针” 。
     反之，移动“右指针”
     */
    public int solution(int[] height) {
        int max = 0 ;
        if(height == null || height.length == 0)
            return max;

        int p1 = 0;
        int p2 = height.length - 1;
        while(p1 < p2){
            int h = Math.min(height[p1], height[p2]);
            max =  Math.max(max, h * (p2 - p1));

            if(height[p1] < height[p2]){
                p1++;
            }
            else{
                p2--;
            }
        }
        return max;
    }
}
