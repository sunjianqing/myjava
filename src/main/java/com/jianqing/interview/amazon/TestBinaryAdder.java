package com.jianqing.interview.amazon;

/**
 * Created by jianqing_sun on 2/7/18.
 */
public class TestBinaryAdder {

    public String add(String s1, String s2, Integer base) {

        if(s1 == null || s1.length() == 0){
            return s2;
        }

        if(s2 == null || s2.length() == 0){
            return s1;
        }

        //TODO: implement
        StringBuilder sb = new StringBuilder();
        int i = s1.length() -1 ;
        int j = s2.length() -1;
        int carry = 0;

        while( i >= 0 || j >= 0 ){
            int sum = carry;
            if(i >= 0) {
        /*
        if(checkRange(s1.charAt(i)) // check current character is in the correct //range , eg [0,1] [0,1,2,3,4,5,6,7,8,9] , [0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F]
          throw new RuntimeException("bad input");
        */
                sum += convertCharToInt(s1.charAt(i--));
            }
            if(j >= 0) {
        /*
        if(checkRange(s2.charAt(j))
          throw new RuntimeException("bad input");
          */

                sum += convertCharToInt(s2.charAt(j--));
            }

            sb.append(sum % base ); // keep the lowest bit
            carry = sum / base;  // keep the carry for the next round

        }

        if(carry != 0){
            sb.append(carry);
        }


        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        TestBinaryAdder t = new TestBinaryAdder();
        String s =  t.add("0","F",16);
        System.out.println(s);
    }

    int convertCharToInt(char c){
        if(c >= '0' && c <= '9'){
            return c - '0';
        }

        if(c >= 'A' && c <= 'F'){
            return 10 + (c - 'A');
        }

        return 0;
    }



}
