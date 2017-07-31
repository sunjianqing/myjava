package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 3/30/17.
 * DFS 找到置0
 *
 */
public class NumberOfIslands_200 {

    /*
        1 1 0 0 0
        1 1 0 0 0
        0 0 1 0 0
        0 0 0 0 0

        用 DFS 找联通的， 然后置0
     */
    public int numIslands(char[][] grid) {
        int cnt = 0;
        if (grid == null || grid.length == 0)
            return 0;
        int row = grid.length;
        int col = grid[0].length;

        if (row == 0 && col == 0)
            return 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    helper(i, j, grid);
                }
            }
        }

        return cnt;

    }

    public void helper(int i, int j, char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        if (i >= row || j >= col || i < 0 || j < 0)
            return;

        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            helper(i, j + 1, grid); // right
            helper(i + 1, j, grid); // down
            helper(i, j-1, grid); // left
            helper(i-1, j , grid); // up
        }

        return;

    }
}
