package com.jianqing.interview.leetcode_category.double_pointer;

public class LC_167 {

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }

        int[] res = new int[2];

        int p1 = 0, p2 = numbers.length - 1;

        while (p1 < p2) {
            if (numbers[p1] + numbers[p2] == target) {
                res[0] = p1 + 1;
                res[1] = p2 + 1;
                break;
            }
            else if (numbers[p1] + numbers[p2] > target) {
                p2 --;
            }
            else {
                p1 ++;
            }
        }

        return res;

    }
}
