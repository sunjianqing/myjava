package com.jianqing.interview.leetcode18;

/*
Input: "112358"
Output: true
Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
             1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 */
public class lc_306 {


    public boolean isAdditiveNumber(String num) {
        if (num == null || num.isEmpty()) {
            return false;
        }

        for (int i = 1; i <= num.length() / 2; i++) {
            for (int j = 1; j < num.length() - i; j++) {
                if(isValid(i , j, num)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isValid(int i, int j, String num) {
        return true;
    }

}
