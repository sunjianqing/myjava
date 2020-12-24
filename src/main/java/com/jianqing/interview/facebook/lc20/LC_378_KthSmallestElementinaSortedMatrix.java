package com.jianqing.interview.facebook.lc20;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC_378_KthSmallestElementinaSortedMatrix {

    public int findKthSmallestPQ(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j< matrix[0].length; j++){
                if(pq.size() < k) {
                    pq.offer(matrix[i][j]);
                }
                else {
                    if (matrix[i][j] < pq.peek()){
                       pq.remove();
                       pq.add(matrix[i][j]);
                    }
                }
            }
        }
        return pq.peek();

    }

    public int findKthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int start = matrix[0][0];
        int end = matrix[n-1][n-1];

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int[] smallLargePair = { matrix[0][0], matrix[n - 1][n - 1]};
            int count = countLessEqual(matrix, mid, smallLargePair);

            if (count == k) {
                return smallLargePair[0];
            }

            if (count < k) {
                start = smallLargePair[1]; // search higher
            }
            else {
                end = smallLargePair[0]; // search lower
            }
        }

        return start;
    }

    /**
     * 行列都有序的matrix,找有多少个 <=k,  可以从左下角或者右上角开始搜，比如从左下角
     * 如果当前值小于k，这当前row以上所有都小于， 所以toal += row + 1， 然后挪col， col ++
     * 如果当年值大于k，挪row, row—
     *
     * @param matrix
     * @param mid
     * @param smallLargePair
     * @return
     */
    private int countLessEqual(int[][] matrix, int mid, int[] smallLargePair) {
        int count = 0;
        int n = matrix.length;
        int row = n -1;
        int col = 0;
        while (row >= 0 && col < n) {
            if(matrix[row][col] > mid) {
               smallLargePair[1] = Math.min(smallLargePair[1], matrix[row][col]);
               row--;
            }
            else {
                smallLargePair[0] = Math.max(smallLargePair[0], matrix[row][col]);
                count += row + 1;
                col ++;
            }
        }

        return count;
    }
}
