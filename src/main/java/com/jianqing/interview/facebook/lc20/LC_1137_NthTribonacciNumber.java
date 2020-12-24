package com.jianqing.interview.facebook.lc20;

public class LC_1137_NthTribonacciNumber {
    public int tribonacci(int n) {
        int f0 = 0;
        int f1 = 1;
        int f2 = 1;
        if (n == 0) return f0;
        if (n == 1) return f1;
        if (n == 2) return f2;

        int res = 0;
        n = n - 3;
        while (n >= 0) {
            res = f0 + f1 + f2;
            f0 = f1;
            f1 = f2;
            f2 = res;
            n--;
        }
        return res;
    }
}
