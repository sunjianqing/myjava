package com.jianqing.interview.facebook.lc20;

public class LC_278_FirstBadVersion {

    public int firstBadVersion(int n) {
        int left = 1, right = n;

        while (left < right - 1) { // 如果写成left + 1 , 会越界
            int mid = left + (right - left) / 2;

            if(isBadVersion(mid)){
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }

        if (isBadVersion(left))
            return left;

        if (isBadVersion(right))
            return right;


        return -1;
    }

    private boolean isBadVersion(int version) {
        return true;
    }
}
