package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 6/1/17.
 */
public class MultiplyStrings_43 {

    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        // m , n 位相乘， 最多m + n 位

        int[] pos = new int[m + n];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p : pos) {
            // 忽略掉前面的 0 
            if(!(sb.length() == 0 && p == 0)) sb.append(p);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
