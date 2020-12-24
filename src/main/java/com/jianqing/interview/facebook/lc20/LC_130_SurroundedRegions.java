package com.jianqing.interview.facebook.lc20;

/**
 * DFS 思路
 * 先从四周找到O， DFS，所有可达的O 都先标记成 # ， 然后扫一遍， 以前的O 都改成X， 再把# 换回来
 */
public class LC_130_SurroundedRegions {

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int m = board.length - 1;
        int n = board[0].length - 1 ;

        for (int i = 0; i <= m; i++) {
           if (board[i][0] == 'O') {
               // DFS
               dfs(i, 0, board);
           }

           if (board[i][n] == 'O') {
               dfs(i, n, board);
           }
        }

        for (int j = 0; j <= n; j++) {
            if (board[0][j] == 'O') {
                dfs(0, j, board);
            }

            if (board[m][j] == 'O') {
                dfs(m, j, board);
            }
        }

        // scan 一遍， O 都变X， #改回O
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(int i, int j, char[][] board) {
        if ( i < 0 || i > board.length - 1 || j < 0 || j > board[0].length -1 || board[i][j] != 'O' )
            return;

        board[i][j] = '#';

        dfs(i-1, j, board);
        dfs(i+1, j, board);
        dfs(i, j-1, board);
        dfs(i, j+1, board);
    }
}
