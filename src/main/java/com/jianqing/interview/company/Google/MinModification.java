package com.jianqing.interview.company.Google;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a matrix of direction with L, R, U, D, at any point you can move to the direction which is written over the cell [i, j]. We have to tell minimum number of modifications to reach from [0, 0] to [N - 1, M - 1] .
 * Example :-
 * <p>
 * R R D
 * <p>
 * L L L
 * <p>
 * U U R
 * <p>
 * Answer is 1, we can modify cell [1, 2] from L To D.
 * <p>
 * RRRRD
 * DLLLL
 * RRRRR
 * <p>
 * Return 0 (蛇形)
 */
public class MinModification {

    public static void main(String[] args) {
        char[][] matrix = new char[][] {
                {'R', 'R', 'D'},
                {'L', 'L', 'L'},
                {'U', 'U', 'R'}
        };

        char[][] matrix2 = new char[][] {
                {'R', 'R', 'R', 'R', 'D'},
                {'D', 'L', 'L', 'L', 'L'},
                {'R', 'R', 'R', 'R', 'R'}
        };

        char[][] matrix3 = new char[][] {
                {'R', 'R', 'R', 'R', 'U'},
                {'U', 'U', 'U', 'U', 'L'},
                {'U', 'R', 'R', 'R', 'R'}
        };


        MinModification mm = new MinModification();
        int solution = mm.solution(matrix3);
        System.out.println(solution);

    }
    public int solution(char[][] matrix) {
        if (matrix == null) {
            return -1;
        }

        int m = matrix.length, n = matrix[0].length;
        int[][] mdf = new int[m][n];
        int[][] visited = new int[m][n];

        // Init
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mdf[i][j] = Integer.MAX_VALUE;
            }
        }

        mdf[0][0] = 0;

        Deque<int[]> queue = new LinkedList<>();
        queue.addFirst(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] pos = queue.pollFirst();
            int r = pos[0];
            int c = pos[1];
            visited[r][c] = 1;
            if (matrix[r][c] == 'R') {
                if (r - 1 >= 0 && visited[r - 1][c] == 0) { // UP
                    mdf[r - 1][c] = Math.min(mdf[r - 1][c], mdf[r][c] + 1);
                    queue.addLast(new int[]{r - 1, c}); // 加到队尾
                }
                if (r + 1 < m && visited[r + 1][c] == 0) { // DOWN
                    mdf[r + 1][c] = Math.min(mdf[r + 1][c], mdf[r][c] + 1);
                    queue.addLast(new int[]{r + 1, c}); // 加到队尾
                }
                if (c - 1 >= 0 && visited[r][c - 1] == 0) { // LEFT
                    mdf[r][c - 1] = Math.min(mdf[r][c - 1], mdf[r][c] + 1);
                    queue.addLast(new int[]{r, c - 1}); // 加到队尾
                }
                if (c + 1 < n && visited[r][c + 1] == 0) { // R
                    mdf[r][c + 1] = Math.min(mdf[r][c + 1], mdf[r][c]);
                    queue.addFirst(new int[]{r, c + 1});  // 加到队首，因为拿出来的时候是最小的， 现在又没做修改， 所以还是最小
                }
            }
            if (matrix[r][c] == 'U') {
                if (r - 1 >= 0 && visited[r - 1][c] == 0) { // UP
                    mdf[r - 1][c] = Math.min(mdf[r - 1][c], mdf[r][c]);
                    queue.addFirst(new int[]{r - 1, c});
                }
                if (r + 1 < m && visited[r + 1][c] == 0) { // DOWN
                    mdf[r + 1][c] = Math.min(mdf[r + 1][c], mdf[r][c] + 1);
                    queue.addLast(new int[]{r + 1, c});
                }
                if (c - 1 >= 0 && visited[r][c - 1] == 0) { // LEFT
                    mdf[r][c - 1] = Math.min(mdf[r][c - 1], mdf[r][c] + 1);
                    queue.addLast(new int[]{r, c - 1});
                }
                if (c + 1 < n && visited[r][c + 1] == 0) { // Right
                    mdf[r][c + 1] = Math.min(mdf[r][c + 1], mdf[r][c] + 1);
                    queue.addLast(new int[]{r, c + 1});
                }
            }
            if (matrix[r][c] == 'L') {

                if (r - 1 >= 0 && visited[r - 1][c] == 0) { // UP
                    mdf[r - 1][c] = Math.min(mdf[r - 1][c], mdf[r][c] + 1);
                    queue.addLast(new int[]{r - 1, c});
                }
                if (r + 1 < m && visited[r + 1][c] == 0) { // DOWN
                    mdf[r + 1][c] = Math.min(mdf[r + 1][c], mdf[r][c] + 1);
                    queue.addLast(new int[]{r + 1, c});
                }
                if (c - 1 >= 0 && visited[r][c - 1] == 0) { // LEFT
                    mdf[r][c - 1] = Math.min(mdf[r][c - 1], mdf[r][c]);
                    queue.addFirst(new int[]{r, c - 1});
                }
                if (c + 1 < n && visited[r][c + 1] == 0) { // Right
                    mdf[r][c + 1] = Math.min(mdf[r][c + 1], mdf[r][c] + 1);
                    queue.addLast(new int[]{r, c + 1});
                }

            }
            if (matrix[r][c] == 'D') {
                if (r - 1 >= 0 && visited[r - 1][c] == 0) { // UP
                    mdf[r - 1][c] = Math.min(mdf[r - 1][c], mdf[r][c] + 1);
                    queue.addLast(new int[]{r - 1, c});
                }
                if (r + 1 < m && visited[r + 1][c] == 0) { // DOWN
                    mdf[r + 1][c] = Math.min(mdf[r + 1][c], mdf[r][c]);
                    queue.addFirst(new int[]{r + 1, c});
                }
                if (c - 1 >= 0 && visited[r][c - 1] == 0) { // LEFT
                    mdf[r][c - 1] = Math.min(mdf[r][c - 1], mdf[r][c] + 1);
                    queue.addLast(new int[]{r, c - 1});
                }
                if (c + 1 < n && visited[r][c + 1] == 0) { // Right
                    mdf[r][c + 1] = Math.min(mdf[r][c + 1], mdf[r][c] + 1);
                    queue.addLast(new int[]{r, c + 1});
                }
            }
        }

        return mdf[m-1][n-1];
    }
}
