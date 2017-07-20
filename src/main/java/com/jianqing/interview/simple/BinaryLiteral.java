package com.jianqing.interview.simple;

/**
 * Created by jianqing_sun on 6/16/17.
 */
public class BinaryLiteral {
    public static void main(String[] args) {
        // An 8-bit 'byte' value:
        byte aByte = (byte)0b00100001;

// A 16-bit 'short' value:
        short aShort = (short)0b1010000101000101;

// Some 32-bit 'int' values:
        int anInt1 = 0b10100001010001011010000101000101;
        int anInt2 = 0b101;
        int anInt3 = 0B110100; // The B can be upper or lower case.

// A 64-bit 'long' value. Note the "L" suffix:
        long aLong = 0b1010000101000101101000010100010110100001010001011010000101000101L;

        // print 5
        System.out.println(anInt2);


        String b5 = Integer.toBinaryString(5);
        // print "101"
        System.out.println(b5);

        System.out.println(anInt3);
        System.out.println(-anInt3);
        System.out.println(Integer.toBinaryString(-anInt3));
        int lastSetBit = (anInt3) & (-anInt3);
        System.out.println(lastSetBit);
    }
}
