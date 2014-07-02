package com.jianqing.interview.leetcode;

/**
 * Created by jianqsun on 6/11/14.
 */
public class SearchForRange {
    int min = -1;
    int max = -1;

    public int[] searchRange(int[] A, int target) {

        int[] res = new int[2];
        res[0] = min;
        res[1] = max;

        findTarget(A, 0, A.length -1, target);

        res[0] = min;
        res[1] = max;

        return res;



    }

    public void findTarget(int[] A, int start, int end, int target){

        if(start == end){
            if(A[start] == target)
            {
                if(start < min || min == -1 ){
                    min = start;
                }
                if(start > max || max == -1 ){
                    max = start;
                }
            }
        }

        else{
            int mid = ( start + end ) / 2 ;
            findTarget(A, start, mid , target);
            findTarget(A, mid+1, end, target);
        }

    }
}
