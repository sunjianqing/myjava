package com.jianqing.interview.facebook.lc20;

/**
 *  Leftmost Column with at Least a One
 *
 *  给一个矩阵和访问矩阵的api,问最左边的包含起码一个1的column的序号
 *
 * 先拿到 矩阵多大 ， m * n
 *
 * 然后从 [m-1, n-1] 开始往回找， 如果碰到0，就往上， 因为每行递减的，说明这行往前的列全是0
 * 如果碰到1，就往左，继续找第一个带1的列
 *
 *
 * 或者 用个二分
 * 二分法的思路也比较直观。
 * 因为每一行是非递减的，所以是在对每一行做二分。
 * 我们一开始先试图对最后一行做二分，得到最后一行的mid坐标之后，我们看在最后一行的mid位置上是否存在1，如果存在，则把mid暂时记录成res，然后可以在left - mid的范围内再次对每一行扫描，看看是否在其他行存在一个index比mid更小的1。
 *
 * 还是第一个好写
 *  interface BinaryMatrix {
 *      public int get(int row, int col) {}
 *      public List<Integer> dimensions {}
 *  };
 *
 */

public class LC_1428_LeftmostColumnWithAtLeastaOne {

}
