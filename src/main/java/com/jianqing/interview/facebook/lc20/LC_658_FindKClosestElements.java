package com.jianqing.interview.facebook.lc20;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary search or
 * 双指针 lo, high 那个差的远 就挪哪个
 *
 */
public class LC_658_FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0;
        int hi = arr.length - 1;
        while (hi - lo >= k) {
            if (Math.abs(arr[lo] - x) > Math.abs(arr[hi] - x)) {
                lo++;
            } else {
                hi--;
            }
        }
        List<Integer> result = new ArrayList<>(k);
        for (int i = lo; i <= hi; i++) {
            result.add(arr[i]);
        }
        return result;
    }

}
