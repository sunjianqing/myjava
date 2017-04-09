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

        if (a.length() < b.length()) {
            //swap a, b
            String tmp = b;
            b = a;
            a = tmp;
        }

        int la = a.length() - 1;
        int lb = b.length() - 1;
        String rst = "";

        int carry = 0;
        while (lb >= 0) {
            int sum = (a.charAt(la) - '0') + (b.charAt(lb) - '0') + carry;
            int currentBit = sum % 2;
            carry = sum / 2;
            rst = String.valueOf(currentBit) + rst;
            lb--;
            la--;
        }

        while (la >= 0) {
            int sum = (a.charAt(la) - '0') + carry;
            int currentBit = sum % 2;
            carry = sum / 2;
            rst = String.valueOf(currentBit) + rst;
            la--;
        }

        if (carry > 0) {
            rst = "1" + rst;
        }

        return rst;

    }
}
