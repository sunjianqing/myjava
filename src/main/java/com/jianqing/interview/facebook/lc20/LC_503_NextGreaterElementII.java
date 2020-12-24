package com.jianqing.interview.facebook.lc20;

import java.util.Arrays;
import java.util.Stack;

/**
 * Stack
 *
 * 碰到 circular array 问题
 * 或者把原数组double 下， 就相当于解决normal 数组问题
 */
public class LC_503_NextGreaterElementII {

    public int[] nextGreaterElements(int[] A) {
        int n = A.length, res[] = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n * 2; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i % n])
                res[stack.pop()] = A[i % n];
            stack.push(i % n);
        }
        return res;
    }
}
