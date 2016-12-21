package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 12/13/16.
 */
public class ArithmeticSlices_413 implements Solution {

    public static void main(String[] args) {
        ArithmeticSlices_413 a = new ArithmeticSlices_413();
        a.solution();
    }

    @Override
    public void solution() {
        int[] a = new int[]{1, 2, 3, 8, 9, 10};
        numberOfArithmeticSlices(a);
    }

    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3)
            return 0;

        int i = 0, j = 1;
        int diff = A[1] - A[0];

        int total = 0;
        while (j < A.length - 1) {
            if (A[j + 1] - A[j] == diff) {
                j++;
            } else {
                if (j - i >= 2) {
                    total += sum(j - i - 1);
                }
                i = j;
                j++;
                diff = A[j] - A[i];
            }
        }

        if (j - i >= 2) {
            total += sum(j - i - 1);
        }

        return total;
    }

    public int sum(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }

        return sum;
    }

    public int numberOfArithmeticSlices2(int[] A) {
        int res = 0, len = 2, n = A.length;
        for (int i = 2; i < n; ++i) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                ++len;
            } else {
                if (len > 2) res += (len - 1) * (len - 2) * 0.5;
                len = 2;
            }
        }
        if (len > 2) res += (len - 1) * (len - 2) * 0.5;
        return res;
    }
}
