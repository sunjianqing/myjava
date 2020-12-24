package com.jianqing.interview.facebook.lc20;

/**
 * https://www.youtube.com/watch?v=ScCg9v921ns
 *
 * 在A ， B 数组里最短的那个数组A中间切开 i
 *
 * 剩下的B 切开的位置 就是 j = totalHalf - i
 *
 *
 * 判断 a[i-1] 跟 b[j] , a[i] 跟 b[j-1] 的大小情况
 * aStart = 0 , aEnd = aLen - 1;
 * if a[i-1] > b[j], i is too big, aEnd have to move mid - 1
 * if a[i] < b[j-1], i is too small , aStart have to mid + 1
 * if a[i-1] > b[j] && a[i] > b[j-1] , 正好有一半
 *
 * Median of Two Sorted Arrays
 */
public class LC_4_MedianofTwoSortedArrays {

    public static void main(String[] args) {
        LC_4_MedianofTwoSortedArrays lc = new LC_4_MedianofTwoSortedArrays();
        lc.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4});
    }
    public double findMedianSortedArrays(int[] A, int[] B) {
        int lenA = A.length;
        int lenB = B.length;

        if (lenA > lenB) {return findMedianSortedArrays(B, A);}

        if (lenA == 0) {
            return ((double) (B[(lenB -1) / 2] + B[lenB / 2]) / 2);
        }

        int half = (lenA + lenB + 1) / 2 ;

        boolean even = (lenA + lenB) % 2 == 0 ? true : false;
        int start = 0;
        int end = lenA;
        int apart = 0;
        int bpart = 0;

        while (start <= end) {
            apart = (start + end) / 2;
            bpart = half - apart;

            if (apart > start && A[apart - 1] > B[bpart]) {
                end = apart - 1;
            }
            else if (apart < end && A[apart] < B[bpart -1]) {
                start = apart + 1;
            }
            else {
                int leftmax = 0;
                if (apart == 0) {
                    leftmax = B[bpart -1];
                }
                else if (bpart ==0) {
                    leftmax = A[apart - 1];
                }
                else {
                    leftmax = Math.max(A[apart-1], B[bpart -1]); // 找离中间最近的
                }

                if(!even) return leftmax;

                int minRight = 0;
                if (apart == lenA) minRight = B[bpart];
                else if (bpart == lenB) minRight = A[apart];
                else {
                    minRight = Math.min(B[bpart], A[apart]);
                }

                return ((double)(leftmax + minRight)) / 2;
            }


        }
        return 0;
    }
}
