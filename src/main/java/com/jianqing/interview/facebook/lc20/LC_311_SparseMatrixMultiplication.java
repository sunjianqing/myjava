package com.jianqing.interview.facebook.lc20;

/**
 * loop 左矩阵的时候， 如果不是0 ， 再计算， 然后放到最后结果里
 */
public class LC_311_SparseMatrixMultiplication {
    public static void main(String[] args) {
        LC_311_SparseMatrixMultiplication lc = new LC_311_SparseMatrixMultiplication();

        lc.multiply2(new int[][]{{1, 0, 0}, {-1, 0, 3}}, new int[][]{{7, 0, 0 }, { 0, 0, 0}, {0, 0, 1 }});
    }

    // Brute force
    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || B == null || A.length == 0 || A[0].length == 0 || B.length == 0 || B[0].length == 0)
            return null;

        int m = A.length;
        int n = B[0].length;

        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < A[0].length; j++) {
               for (int k = 0; k < B.length; k++){
                res[i][k] += A[i][j] * B[k][j];
               }
            }
        }

        return res;
    }

    // 如果a[i][j] !=0 , 再累加到 a[i][k] 里， 这个思路不是一次型的算完res[i][k], 而是累积的往里加数
    public int[][] multiply2(int[][] A, int[][] B) {
        if (A == null || B == null || A.length == 0 || A[0].length == 0 || B.length == 0 || B[0].length == 0)
            return null;

        int m = A.length;
        int n = A[0].length;
        int l = B[0].length;

        int[][] res = new int[m][l];

        // loop A, 让后往 res[i][k] 里累加
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(A[i][j] !=0) {
                    for (int k = 0; k < B[0].length; k++) {
                        res[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }

        return res;
    }
}
