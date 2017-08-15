package com.jianqing.interview.facebook;

/**
 * Created by jianqing_sun on 8/10/17.
 */
public class LongestArithmeticProgression_F {
    public static void main(String[] args) {
        int[] A = {1, 7, 10, 15, 27, 29};
        System.out.println(arithmeticThree(A, A.length));
        System.out.println(lengthOfLongestAP(A, A.length));
        int[] B = {1, 7, 10, 15, 27, 28};
        System.out.println(arithmeticThree(B, B.length));
        System.out.println(lengthOfLongestAP(B, B.length));
    }

    // 判断是否有等差数列的存在
    public static boolean arithmeticThree(int[] A, int n) {
        for (int j = 1; j < n - 1; j++) {        // j为等差数列中间那个数
            int i = j - 1, k = j + 1;
            while (i >= 0 && k <= n - 1) {
                if (A[i] + A[k] == 2 * A[j]) {    // 找到
                    return true;
                } else if (A[i] + A[k] > 2 * A[j]) {    // 过大
                    i--;
                } else {  // 过小
                    k++;
                }
            }
        }
        return false;
    }

    // Returns length of the longest AP subset in a given set
    // O(n^2) time, space
    public static int lengthOfLongestAP(int[] A, int n) {
        if (n <= 2) {
            return n;
        }

        // Create a table and initialize all values as 2. The value of
        // L[i][j] stores LLAP with A[i] and A[j] as first two
        // elements of AP. Only valid entries are the entries where j>i
        int[][] L = new int[n][n];      // L[i][j]: 以A[i]和A[j]为前两项的最长等差数列项数
        int llap = 2;       // 最长等差数列项数

        // Fill entries in last column as 2. There will always be
        // two elements in AP with last number of set as second
        // element in AP
        for (int i = 0; i < n; i++) {
            L[i][n - 1] = 2;
        }

        // Consider every element as second element of AP
        for (int j = n - 2; j >= 1; j--) {
            int i = j - 1, k = j + 1;       // Search for i and k for j
            while (i >= 0 && k <= n - 1) {
                if (A[i] + A[k] < 2 * A[j]) {
                    k++;
                } else if (A[i] + A[k] > 2 * A[j]) {    // Before changing i, set L[i][j] as 2
                    L[i][j] = 2;        // 初始化，项数至少为2
                    i--;
                } else {
                    // Found i and k for j, LLAP with i and j as first two
                    // elements is equal to LLAP with j and k as first two
                    // elements plus 1. L[j][k] must have been filled
                    // before as we run the loop from right side
                    L[i][j] = L[j][k] + 1;  // 因为包括了[i,j]和[j,k]两项，比原来的[j,k]多了一项

                    // Update overall LLAP, if needed
                    llap = Math.max(llap, L[i][j]);

                    // Change i and k to fill more L[i][j] values for current j
                    i--;
                    k++;
                }
            }

            // If the loop was stopped due to k becoming more than
            // n-1, set the remaining entities in column j as 2
            while (i >= 0) {
                L[i][j] = 2;
                i--;
            }
        }

        return llap;
    }
}
