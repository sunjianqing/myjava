package com.jianqing.interview.facebook.lc20;

/**
 * Add Strings
 *
 * 给俩字符串代表的数，求和
 *
 *
 */
public class LC_415_AddString {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.isEmpty()) {
            return num2;
        }

        if (num2 == null || num2.isEmpty()) {
            return num1;
        }

        int m = num1.length() - 1;
        int n = num2.length() - 1;
        int carry = 0;

        StringBuilder sb = new StringBuilder();
        while (m >= 0 && n >= 0) {
            char c1 = num1.charAt(m);
            char c2 = num2.charAt(n);

            int tmp = (c1 - '0') + (c2 - '0') + carry;
            carry = tmp / 10;
            sb.append(tmp % 10);

            m--;
            n--;
        }

        if (m >= 0) {
            while (m >=0) {
                int tmp = num1.charAt(m) - '0' + carry   ;
                carry = tmp / 10;
                sb.append(tmp % 10);
                m--;
            }
        }

        if (n >= 0) {
            while (n >=0) {
                int tmp = num2.charAt(n) - '0' + carry   ;
                carry = tmp / 10;
                sb.append(tmp % 10);
                n--;
            }
        }

        if (carry > 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();

    }

    public String addStrings2(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        char[] num1Array = num1.toCharArray();
        char[] num2Array = num2.toCharArray();
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry == 1) {
            int a = i >= 0 ? (num1Array[i--] - '0') : 0;
            int b = j >= 0 ? (num2Array[j--] - '0') : 0;
            int sum = a + b + carry;
            sb.insert(0, sum % 10);
            carry = sum / 10;
        }
        return sb.toString();
    }
}
