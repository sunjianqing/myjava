package com.jianqing.interview.leetcode18;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Kth smallest element in sorted matrix
 */
public class lc_378 {

    public static void main(String[] args) {

        int[][] matrix = new int[][]{
                {1,5,7},
                {7,8,9},
                {10,11, 12}
        };

        int res = lc_378.kthSmallest(matrix, 7);
        System.out.println(res);
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int[] dx = new int[]{0, 1};
        int[] dy = new int[]{1, 0};
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] hash = new boolean[n][m];
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>(k, new PairComparator());
        minHeap.add(new Pair(0, 0, matrix[0][0]));

        for (int i = 0; i < k - 1; i++) {
            Pair cur = minHeap.poll();
            for (int j = 0; j < 2; j++) {
                int next_x = cur.x + dx[j];
                int next_y = cur.y + dy[j];
                Pair next_Pair = new Pair(next_x, next_y, 0);
                if (next_x < n && next_y < m && !hash[next_x][next_y]) {
                    hash[next_x][next_y] = true;
                    next_Pair.val = matrix[next_x][next_y];
                    minHeap.add(next_Pair);
                }
            }
        }
        return minHeap.peek().val;
    }

}

class Pair {
    public int x, y, val;
    public Pair(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
class PairComparator implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
        return a.val - b.val;
    }
}

