package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 8/19/17.
 */
public class FirstBadVersion_278 {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while(start < end ){
            int mid = start + (end - start) / 2 ;
            if(!isBadVersion(mid))
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }

    boolean isBadVersion(int version){
        return true;
    }
}
