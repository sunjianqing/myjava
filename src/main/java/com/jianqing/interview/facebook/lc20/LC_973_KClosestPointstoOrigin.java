package com.jianqing.interview.facebook.lc20;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * K Closest Points to Origin
 *
 * Priority Queue O(NlogK)
 *
 * or
 *
 * Quick Select : the average time complexity is O(N)
 */
public class LC_973_KClosestPointstoOrigin {

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] * o2[0] + o2[1] * o2[1] - o1[0] * o1[0] - o1[1] * o1[1];
            }
        });


        for (int i = 0; i < points.length; i++) {
            pq.add(points[i]);
            if(pq.size() > K) {
                pq.poll();
            }
        }

        int[][] res = new int[K][2];
        while (K > 0) {
            res[--K] = pq.poll();
        }
        return res;
    }


    public int[][] kClosestQuickSelect(int[][] points, int K) {
        int len =  points.length, l = 0, r = len - 1;
        while (l <= r) {
            int mid = helper(points, l, r);
            if (mid == K) break;
            if (mid < K) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    private int helper(int[][] A, int l, int r) {
        int[] pivot = A[l];
        while (l < r) {
            while (l < r && compare(A[r], pivot) >= 0) r--;
            A[l] = A[r];
            while (l < r && compare(A[l], pivot) <= 0) l++;
            A[r] = A[l];
        }
        A[l] = pivot;
        return l;
    }

    private int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }

}
