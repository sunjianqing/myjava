package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 2/6/17.
 */
public class SetMatrixZeroes_73 implements Solution {

    /**
     * scan 一遍数组的时候， mark 这个位置是不是应该置0， 不能scan 的时候就置0， 那样， 有些位置就会错误的置0
     *
     * 不省空间， 就再开辟一个m n 的数组， 记录每一个格是不是应该把对应的行列置0 ，
     * 省空间的话， 可以利用第一行和列 记录
     */
    @Override
    public void solution() {

    }
}
