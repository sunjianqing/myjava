package com.jianqing.interview.facebook;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jianqingsun on 8/8/17.
 * <p>
 * 3 sum equal 0
 */
public class Sum3_F {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        int len = num.length;
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < len - 2; i++) {

            if(i == 0 || (i > 0 && num[i] !=  num[i-1])) {
                int lo = i + 1;
                int hi = len - 1;
                int sum = 0 - num[i];

                while(lo < hi) {
                    if(num[lo] + num[hi] < sum) {
                        lo++;
                    }
                    else if(num[lo] + num[hi] > sum) {
                        hi--;
                    }
                    else {
                        // found
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));

                        while(lo < hi && num[lo] == num[lo+1]) lo++;
                        while(lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++;
                        hi--;
                    }


                }
            }
        }
        return res;
    }
}
