package com.jianqing.interview.leetcode16;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianqing_sun on 2/17/17.
 */
public class RemoveDuplicatesfromSortedArrayII_80  {

    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArrayII_80 r = new RemoveDuplicatesfromSortedArrayII_80();
        int[] nums = new int[]{1,1,1,2};
        int[] ints = r.removeDuplicates(nums);
        System.out.println(ints);
    }
    public int[] removeDuplicates(int[] nums) {
        List<Integer> res = new ArrayList();
        if (nums.length == 0)
            return new int[]{};

        int i = 1 ;
        int total = 1;
        int last = nums[0];
        res.add(last);
        int dup = 1;
        while( i < nums.length) {
            if ( nums[i] == last ) {
                dup++;
                if (dup <= 2) {
                    total++ ;
                    res.add(last);
                }
            }
            else {
                last = nums[i];
                res.add(last);
                total++;
                dup = 1;
            }

            i++;
        }

        int[] ret = new int[res.size()];
        for(int index = 0;index < ret.length;index++)
            ret[index] = res.get(index);
        return ret;

    }
}
