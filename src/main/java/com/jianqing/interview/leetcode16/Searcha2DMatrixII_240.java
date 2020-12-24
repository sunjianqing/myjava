package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 1/11/17.
 *
 *
 */
public class Searcha2DMatrixII_240 implements Solution {
    private static Searcha2DMatrixII_240 ourInstance = new Searcha2DMatrixII_240();

    public static Searcha2DMatrixII_240 getInstance() {
        return ourInstance;
    }

    private Searcha2DMatrixII_240() {
    }

    @Override
    public void solution() {

    }

    /**
     * 此题有几个算法
     * 1， 从左下角开始搜， 目标数大就往右搜， 小就往上搜
     * 2， 两层循环，第一层行（行从0 开始）， 第二层列 (列循环从最后一列开始)，如果matrix[x][y] > target
     * y就-1
     * 3， 两层循环， 第一层行， 第二层列， 对列用binary search
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if ( matrix.length == 0)
            return false;

        int x = matrix.length;
        int y = matrix[0].length;

        int i = x - 1;
        int j = 0;
        while (i >= 0 && j < y) {
            if (matrix[i][j] == target)
                return true;

            if (matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }

    // 2 刷
    public boolean searchMatrix2(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int i = 0;
        int j = n - 1;
        while (i < m && j < n && i >=0 && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            else if (matrix[i][j] < target) {
                i ++;
            }
            else {
                j--;
            }
        }

        return false;
    }
}
