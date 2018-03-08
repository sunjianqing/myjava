package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 3/14/17.
 */
public class AddBinary_67 {

    public static void main(String[] args) {
        AddBinary_67 ab = new AddBinary_67();
        ab.addBinary("100","110010");
    }
    public String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }

        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();

    }
}
