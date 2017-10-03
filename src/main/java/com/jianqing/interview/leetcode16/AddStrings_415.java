package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 11/30/16.
 *
 * refer http://blog.csdn.net/cloudox_/article/details/52774834
 *
 */
public class AddStrings_415 {

    public String addStrings(String num1, String num2){
        if(num1.isEmpty() && num2.isEmpty())
            return "";

        if(num2.isEmpty())
            return num1;

        if(num1.isEmpty())
            return num2;


        int carry = 0 ;
        if(num1.length() > num2.length()){
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        while(i >= 0){
            int sum = Character.getNumericValue(num1.charAt(i)) + Character.getNumericValue(num2.charAt(j)) + carry;
            sb.insert(0, sum % 10) ;
            carry = sum / 10;
            i--;
            j--;
        }

        while(j >=0 ) {
            int sum =   Character.getNumericValue(num2.charAt(j)) + carry;
            sb.insert(0, sum % 10) ;
            carry = sum / 10;
            j--;
        }
        if(carry != 0) {
            sb.insert(0, carry);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        AddStrings_415 as = new AddStrings_415();
        as.addStrings("9","99");

    }
}
