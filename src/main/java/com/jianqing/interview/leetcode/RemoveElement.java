package com.jianqing.interview.leetcode;

/**
 * Created by jianqsun on 6/20/14.
 */
public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        int res = 0;
        int i = 0;
        int j = 0;
        for( ; i < A.length; i++){
            if(A[i] != elem){
                A[j++] = A[i];
            }
        }

        return j;
    }
}
