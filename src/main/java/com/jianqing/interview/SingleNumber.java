package com.jianqing.interview;

/**
 * Created with IntelliJ IDEA.
 * User: jianqsun
 * Date: 11/18/13
 * Time: 11:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class SingleNumber {
    public int solution(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int res = 0;
        for(int i = 0 ; i < A.length; i++)
            res ^= A[i];
        return res;
    }

    public static void main(String[] args){
        int[] a = {1, 2, 3, 3, 2, 4, 1};
        SingleNumber sn = new SingleNumber();
        System.out.println(sn.solution(a));

    }
}
