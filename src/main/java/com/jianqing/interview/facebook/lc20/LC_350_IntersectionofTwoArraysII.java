package com.jianqing.interview.facebook.lc20;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 找重复数， 但是不是找连续的重叠部分
 */
public class LC_350_IntersectionofTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length ==0 || nums2 ==null || nums2.length ==0) {
            return new int[]{};
        }

        Map<Integer, Integer> map1 = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            map1.put(nums1[i], map1.getOrDefault(nums1[i], 0) + 1);
        }

        List<Integer> resList = new ArrayList<>();

        for (int j = 0; j < nums2.length; j++) {
            if (map1.containsKey(nums2[j]) && map1.get(nums2[j]) > 0) {
                resList.add(nums2[j]);
                map1.put(nums2[j], map1.get(nums2[j]) - 1);
            }
        }

        int[] r = new int[resList.size()];
        for (int i = 0; i < r.length; i++) {
            r[i] = resList.get(i);
        }

        return r;
    }

}
