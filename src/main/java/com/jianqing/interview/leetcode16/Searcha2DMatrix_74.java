package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 1/29/17.
 *
 * Search a 2D Matrix
 */
public class Searcha2DMatrix_74 {

    // Do binary search in this "ordered" matrix
    // 把数组看成一个一维的
    public boolean searchMatrix2(int[][] matrix, int target) {

        int row_num = matrix.length;
        int col_num = matrix[0].length;

        int begin = 0, end = row_num * col_num - 1;

        while(begin <= end){
            int mid = (begin + end) / 2;
            int mid_value = matrix[mid/col_num][mid%col_num];

            if( mid_value == target){
                return true;

            }else if(mid_value < target){
                //Should move a bit further, otherwise dead loop.
                begin = mid+1;
            }else{
                end = mid-1;
            }
        }

        return false;
    }


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
