package com.jianqing.interview.leetcode16;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianqingsun on 5/13/17.
 */
public class SummaryRanges_228 {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return res;

        }

        if (nums.length == 1) {
            res.add(String.valueOf(nums[0]));
            return res;
        }

        int p1 = 0, p2 = 1;
        int start = 0, end = 0;
        while (p2 < nums.length) {
            if (nums[p2] - nums[p1] == 1) {
                p2++;
                p1++;
            } else {
                end = p1;
                addRes(start, end, res, nums);
                p1 = p2;
                start = p1;
                p2++;
            }
        }
        end = nums.length - 1;
        addRes(start, end, res, nums);
        return res;
    }

    private void addRes(int start, int end, List<String> res, int[] nums) {
        if (start != end) {
            res.add(nums[start] + "->" + nums[end]);
        } else {
            res.add(String.valueOf(nums[start]));
        }
    }

    public List<String> cleanCode(int[] nums) {
        List<String> list = new ArrayList();
        int n = nums.length;
        if (n == 1) {
            list.add(nums[0] + "");
            return list;
        }
        for (int i = 0; i < n; i++) {
            int start = nums[i];
            while (i + 1 < n && (nums[i + 1] - nums[i]) == 1) {
                i++;
            }
            if (start != nums[i]) {
                list.add(start + "->" + nums[i]);
            } else {
                list.add(start + "");
            }
        }
        return list;
    }

}
