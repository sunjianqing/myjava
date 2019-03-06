package com.jianqing.interview.leetcode18;

/**
 *  Super Ugly Number
 *
 *  Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.
 *
 * Example:
 *
 * Input: n = 12, primes = [2,7,13,19]
 * Output: 32
 * Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12
 *              super ugly numbers given primes = [2,7,13,19] of size 4.
 *
 * 跟 Ugly Number II 差不多， 用一个array maintain primes 里的数的在最终结果的index，
 * 一开始， 都指向位置0， 对应的ugly number 是1
 */
public class lc_313 {

    public static void main(String[] args) {
        int[] primes = new int[]{2,7,13,19};
        lc_313 lc = new lc_313();
        int number = lc.nthSuperUglyNumber(12, primes);
        System.out.println(number);
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] primesIdx = new int[primes.length];

        int[] uglyNumbers = new int[n];

        uglyNumbers[0] = 1;
        int i = 1;
        while(i < n){
            int min = Integer.MAX_VALUE;
            int minIndex = -1; // which prime number (index) make the product min
            for(int j = 0 ; j < primes.length; j++){
                if(uglyNumbers[primesIdx[j]] * primes[j] <= min){
                    minIndex = j;
                    min = uglyNumbers[primesIdx[j]] * primes[j];
                }
            }
            uglyNumbers[i++] = uglyNumbers[primesIdx[minIndex]] * primes[minIndex];

            // 可能有乘积都等于最小值， 都得更新
            for(int j = 0 ; j < primes.length; j++){
                if(uglyNumbers[primesIdx[j]] * primes[j] == uglyNumbers[primesIdx[minIndex]] * primes[minIndex]){
                    primesIdx[j]++;
                }
            }
        }

        return uglyNumbers[n - 1];

    }
}
