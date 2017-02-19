package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 1/29/17.
 */
public class Searcha2DMatrix_74 {

    /**
     * 二分查找行， 然后再二分查找列
     * 注意， 二分查找行不能用传统的二分查找， 检验条件是start + 1 < end, mid也不能丢掉
     * 二分查找列的时候， 可以用传统的二分查找， mid 如果不满足， 可以丢掉
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int row = matrix.length;
        int col = matrix[0].length;

        // binary search on row
        int start = 0;
        int end = row - 1;

        while (start + 1 < end) {
            int m = start + (end - start) / 2;

            if (target == matrix[m][0])
                return true;
            else if (target < matrix[m][0]) {
                end = m;
            } else {
                start = m;
            }
        }

        if (matrix[end][0] <= target) {// here should be <= , not <
            row = end;
        } else if (matrix[start][0] <= target) {// here should be <= , not <
            row = start;
        } else
            return false;

        // binary search on col
        start = 0;
        end = col - 1;
        while (start <= end) {
            int m = start + (end - start) / 2;
            if (matrix[row][m] == target)
                return true;
            else if (matrix[row][m] > target) {
                end = m - 1;
            } else
                start = m + 1;
        }
        return false;

    }
}
