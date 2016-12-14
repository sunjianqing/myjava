package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 12/13/16.
 */
public class BattleshipsinABoard_419 implements Solution {
    @Override
    public void solution() {

    }

    /*
      扫一遍， 每次发现当前节点是X， 并且左边和上边都为空的时候，是一艘新的battleship
     */
    public int countBattleships(char[][] board) {
        if(board == null)
            return 0;

        int m = board.length;
        int n = board[0].length;
        int cnt = 0;
        for(int i = 0 ; i < m ; i++){
            for ( int j = 0; j < n ; j++){
                if( board[i][j] == 'X'
                        && ( j == 0 || ( j-1 >= 0 && board[i][j-1] != 'X'))
                        && ( i == 0 || (i -1 >= 0 && board[i-1][j] != 'X'))){
                    cnt ++;
                }
            }
        }

        return cnt;
    }
}
