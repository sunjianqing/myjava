package com.jianqing.interview.leetcode;

/**
 * Created by jianqsun on 6/20/14.
 */
public class RemoveDupFromSortedArray {
    public int removeDuplicates(int[] A) {
        int i = 0;
        int j = 0;
        int pos = 0;
        if(A.length == 0){
            return 0;
        }
        while(j < A.length){
            if(A[i] == A[j]){
                j++;
            }
            else{
                A[pos++] = A[i];
                i = j;
            }
        }
        A[pos++] = A[i]; // don't forget the last round
        return pos;
    }
}
