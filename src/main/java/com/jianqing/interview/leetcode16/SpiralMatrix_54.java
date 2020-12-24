package com.jianqing.interview.leetcode16;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianqing_sun on 10/6/17.
 * 可以设4个变量， top, bottom, left, right
 * 然后从左到右遍历， 然后top + 1
 * 然后从上到下遍历， 然后right - 1
 * 然后从右到左遍历， 然后bottom + 1
 * 然后从下到上遍历， 然后left - 1
 *
 * 每一次遍历到底要判断下操作， 出界了，就退出
 * 
 */
public class SpiralMatrix_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        return res;
    }
}
