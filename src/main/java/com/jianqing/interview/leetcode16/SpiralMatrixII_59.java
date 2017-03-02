package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 1/11/17.
 */
public class SpiralMatrixII_59 implements Solution {
    @Override
    public void solution() {

    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int upBound = 0;
        int downBound = n - 1;
        int leftBound = 0;
        int rightBound = n - 1;

        int num = 1;
        while (leftBound <= rightBound) {

            int i = upBound;
            int j = leftBound;
            while (j <= rightBound) {
                if (matrix[i][j] == 0)
                    matrix[i][j] = num++;
                j++;
            }
            j--;

            while (i <= downBound) {
                if (matrix[i][j] == 0)
                    matrix[i][j] = num++;
                i++;
            }
            i--;

            while (j >= leftBound) {
                if (matrix[i][j] == 0)
                    matrix[i][j] = num++;
                j--;
            }
            j++;

            while (i >= upBound) {
                if (matrix[i][j] == 0)
                    matrix[i][j] = num++;
                i--;
            }

            upBound++;
            downBound--;
            leftBound++;
            rightBound--;
        }

        return matrix;
    }
}
