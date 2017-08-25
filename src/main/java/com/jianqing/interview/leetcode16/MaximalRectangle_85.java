package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 8/18/17.
 *
 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0
 */
public class MaximalRectangle_85 {

    // Solution 1
    /*
        每一行看成是 histogram ， 然后求最大矩形
        套 Largest Rectangle in Histogram 解法
     */
    public int maximalRectangle(char[][] matrix) {
        return 0;
    }

     /*
        Solution 2
        这个很难理解

        把直方图倒过来想
        对于每一个点 (i,j), 如果这点是 1， 那么这点上所能形成的最大矩形，由三个因素决定，
        这点垂直高度 h（如果上面一点 是0 ， 这点高度就是1 ， 如果不是0 ， 那就用上点高度加1），
        以高度h 这点左边界能到达的最远距离（注意， 表现在程序里， 是求左边最大的index， 就是上一行跟这一行可到最左边的index里， 找index 最大的， 尽量靠近当前点），
        以及 以高度h 这点右边界能到达的最远距离（注意， 表现在程序里， 是求右边的最小的index，就是上一行跟这一行可到最右边的index里， 找index 最小的， 尽量靠近当前点）

        还有right index 要大1 ， 不然减的时候， 会是0 ， 再乘以高度， 就是0 了

        这样算完之后， 用公式 算出这一行里每点可以形成的矩形的面积， 找最大的
        int area = (right[j] - left[j]) * height[j];


        matrix:
        0 0 0 1 0 0 0
        0 0 1 1 1 0 0
        0 1 1 1 1 1 0

        各点height, left及right值如下：

        row 0:
        h: 0 0 0 1 0 0 0
        l: 0 0 0 3 0 0 0
        r: 7 7 7 4 7 7 7

        row 1:
        h: 0 0 1 2 1 0 0
        l: 0 0 2 3 2 0 0
        r: 7 7 5 4 5 7 7

        row 2:
        h: 0 1 2 3 3 1 0
        l: 0 1 2 3 2 1 0
        r: 7 6 5 4 5 6 7

        比如最后一行求面积的时候
        (5-2) * 2
        (4-3) * 3
        (5-2) * 3
        (6-1) * 1

        最大的是 6
      */

    public int maximalRectangle2(char[][] matrix) {
        return 0;
    }
}
