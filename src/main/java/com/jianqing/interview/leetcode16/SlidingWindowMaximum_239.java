package com.jianqing.interview.leetcode16;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Sliding Window Maximum
 * Created by jianqingsun on 8/5/17.
 *
 * 创建一个单调队列 （monotonic queue）, 就是始终保持队头是最大的，如果新进来一个k比对尾大的，那就可以一路删除到队列中比k大的位置
 */
public class SlidingWindowMaximum_239 {
    public int[] maxSlidingWindow(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k, 如果最大的是窗口外的， 去掉它
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless 从队尾删掉元素， 直到要删掉的不比当前的小了
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) { // 每次拿队首
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }
}
