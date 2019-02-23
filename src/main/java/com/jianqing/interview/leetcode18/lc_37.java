package com.jianqing.interview.leetcode18;

//Sudoku Solver

public class lc_37 {

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return;
        solve(board);
    }

    public boolean solve(char[][] board){

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++){

                if(board[i][j] == '.'){
                    char c = '1';
                    for(int k = 0 ; k < 9; k++){
                        char nc = (char)((int)c+k);
                        if(isValid(board, i, j, nc)){
                            board[i][j] = nc; // 递归之前设置下
                            if(solve(board)){
                                return true;
                            }
                            else {
                                board[i][j] = '.';
                            }
                        }
                    }

                    // 如果对一个格子尝试从0~9都不行，
                    // 那么说明整个sudoku无解，返回false
                    return false;


                }
            }
        }

        return true;

    }

    public boolean isValid(char[][] board, int i, int j, char nc){

        for(int p = 0; p<9; p++){
           if(board[i][p] == nc)
               return false;
        }

        for(int p = 0; p<9; p++){
            if(board[p][j] == nc)
                return false;
        }

        int leftTopRowIndex = 3 *(i / 3);
        int leftTopColIndex = 3 *(j / 3);

        for(int p = leftTopRowIndex; p< leftTopRowIndex+3; p++){
            for(int q = leftTopColIndex; q < leftTopColIndex+3;q++){
                if(board[p][q] == nc){
                    return false;
                }
            }
        }

        return true;

    }


}
