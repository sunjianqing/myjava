package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 1/22/17.
 */
public class ContainerWithMostWater_11 implements Solution {
    /**
     Solution 1:
     记录比较所有可能 a[i][j] = (j - i ) min (w[i], w[j])
     Solution 2:
     通过两个“指针”，分别指向头和尾。

     分别往中间移动，
     当 “左指针” 指向的线段长度小于“右指针”指向的线段长度，则移动 “左指针” 。
     反之，移动“右指针”
     */
    @Override
    public void solution() {

    }
}
