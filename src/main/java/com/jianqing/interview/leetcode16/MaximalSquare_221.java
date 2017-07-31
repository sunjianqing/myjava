package com.jianqing.interview.leetcode16;


/**
 * Created by jianqing_sun on 5/24/17.
 */
public class MaximalSquare_221 {
    public static void main(String[] args) {

        MaximalSquare_221 ms = new MaximalSquare_221();
        char[][] matrix = new char[4][5];
        matrix[0] = "10100".toCharArray();
        matrix[1] = "10111".toCharArray();
        matrix[2] = "11111".toCharArray();
        matrix[3] = "10010".toCharArray();

        ms.solution(matrix);

        //MaximalSquare_221 ms = new MaximalSquare_221();

    }

    public static Object test() {
        return null;
    }

    public int maximalSquare(char[][] matrix) {
        int res = 0;
        if (matrix == null || matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                res = 1;
            }
        }

        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == '1') {
                dp[0][j] = 1;
                res = 1;
            }
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != '0') {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                    if (dp[i][j] * dp[i][j] > res)
                        res = dp[i][j] * dp[i][j];
                }
            }
        }

        return res;
    }

    // 节省空间做法， 两个长度n 的数组 就够了
    public int solution(char[][] matrix) {
        int res = 0;
        if (matrix == null || matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;


        int[] pre = new int[n];
        int[] curr = new int[n];


        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == '1') {
                pre[j] = 1;
                res = 1;
            }
        }

        int i = 1;
        while (i < m) {

            curr[0] = matrix[i][0] - '0';
            res = Math.max(res, curr[0]);
            int j = 1;
            while (j < n) {
                curr[j] = matrix[i][j] - '0' == 0 ? 0 : Math.min(Math.min(pre[j], pre[j - 1]), curr[j - 1]) + 1;
                res = Math.max(res, curr[j]);
                j++;
            }

            // copy curr to pre

            for (int k = 0; k < n; k++) {
                pre[k] = curr[k];
            }
            i++;

            for (int k = 0; k < n; k++) {
                curr[k] = 0;
            }
        }


        return res * res;

    }
}
