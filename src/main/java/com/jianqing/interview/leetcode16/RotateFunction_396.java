package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 4/17/17.
 * <p>
 * 规律
 * F(0) = 0A + 1B + 2C +3D
 * <p>
 * F(1) = 0D + 1A + 2B +3C
 * <p>
 * F(2) = 0C + 1D + 2A +3B
 * <p>
 * F(3) = 0B + 1C + 2D +3A
 * <p>
 * 那么，我们通过仔细观察，我们可以得出下面的规律：
 * <p>
 * F(1) = F(0) + sum - 4D
 * <p>
 * F(2) = F(1) + sum - 4C
 * <p>
 * F(3) = F(2) + sum - 4B
 */
public class RotateFunction_396 {
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0)
            return 0;

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }


        int fsum = 0;
        for (int i = 0; i < A.length; i++) {
            fsum += i * A[i];
        }

        int n = A.length;
        int max = fsum;
        for (int i = 1; i < n; i++) {
            int tmp = fsum + sum - n * A[n - i];
            max = Math.max(tmp, max);
            fsum = tmp;
        }

        return max;
    }
}
