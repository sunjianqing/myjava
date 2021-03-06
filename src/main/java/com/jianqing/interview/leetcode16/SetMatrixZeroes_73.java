package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 2/6/17.
 */
public class SetMatrixZeroes_73 implements Solution {

    /**
     * scan 一遍数组的时候， mark 这个位置是不是应该置0， 不能scan 的时候就置0， 那样， 有些位置就会错误的置0
     * <p>
     * 不省空间， 就再开辟一个m n 的数组， 记录每一个格是不是应该把对应的行列置0 ，
     * 省空间的话， 可以利用第一行和列 记录
     */
    @Override
    public void solution() {

    }

    public void setZeroes(int[][] matrix) {
        boolean row0 = false;
        boolean col0 = false;
        int m = matrix.length;
        int n = matrix[0].length;


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0){
                    if(i == 0){
                        row0 = true; // 保留住第0行信息
                    }
                    if(j == 0){
                        col0 = true; // 保留住第0列信息
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int j = 1; j < n; j++){
            if(matrix[0][j] == 0){
                for(int i = 0 ; i < m; i++){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i = 1; i < m; i++){
            if(matrix[i][0] == 0){
                for(int j = 0 ; j < n; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        if(row0){
            for(int j = 0 ; j < n; j++){
                matrix[0][j] = 0;
            }
        }

        if(col0){
            for(int i = 0 ; i < m; i++){
                matrix[i][0] = 0;
            }
        }


    }
}
