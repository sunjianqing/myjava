package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 7/20/17.
 *
 * 稀疏矩阵 要等不适0 的时候再乘
 */
public class SparseMatrixMultiplication_311 {

    public int[][] multiply(int[][] A, int[][] B) {
        int rowA = A.length, colA = A[0].length, colB = B[0].length;
        int[][] res = new int[rowA][colB];

        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colA; j++) {
                if (A[i][j] != 0) {// Check whether A[i][j]==0 to spare much time, because a sparse matrix has more than 95% zero elements
                    for (int k = 0; k < colB; k++) {
                        res[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }
        return res;
    }
}
