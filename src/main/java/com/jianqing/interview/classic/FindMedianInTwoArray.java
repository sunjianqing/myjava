package com.jianqing.interview.classic;

/**
 * Created by jianqing_sun on 10/9/17.
 * <p>
 * General 的方法就是找k 大的
 */
public class FindMedianInTwoArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int k = (m + n) / 2;
        if ((m + n) % 2 == 0) {
            return (findKth(nums1, nums2, 0, 0, m, n, k) + findKth(nums1, nums2, 0, 0, m, n, k + 1)) / 2;
        } else {
            return findKth(nums1, nums2, 0, 0, m, n, k + 1);
        }

    }

    // log(k) worst case 才是 k = m + n , 复杂度变成了log(k) =  log(m+n) = log(m) + log(n)
    private double findKth(int[] arr1, int[] arr2, int start1, int start2, int len1, int len2, int k) {
        // 保证arr1是较短的数组
        if (len1 > len2) {
            return findKth(arr2, arr1, start2, start1, len2, len1, k);
        }
        if (len1 == 0) {
            return arr2[start2 + k - 1];
        }
        if (k == 1) {
            return Math.min(arr1[start1], arr2[start2]);
        }
        int p1 = Math.min(k / 2, len1);
        int p2 = k - p1;
        if (arr1[start1 + p1 - 1] < arr2[start2 + p2 - 1]) {
            return findKth(arr1, arr2, start1 + p1, start2, len1 - p1, len2, k - p1);
        } else if (arr1[start1 + p1 - 1] > arr2[start2 + p2 - 1]) {
            return findKth(arr1, arr2, start1, start2 + p2, len1, len2 - p2, k - p2);
        } else {
            return arr1[start1 + p1 - 1];
        }
    }

    // log(m) + log(n)
    /*
        A[i] <= B[j]
        k > i+j+1，搜索A[i+1:m-1]和B[0:n-1]中的第k-i-1个元素
        k <= i+j+1，搜索A[0:m-1]和B[0:j-1]中的第k个元素
        A[i] > B[j]
        k > i+j+1，搜索A[0:m-1]和B[j+1:n-1]中的第k-j-1个元素
        k <= i+j+1，搜索A[0:i-1]和B[0:n-1]中的第k个元素
        base case:
        如果搜索A[s:e]且s>e，即A搜索完了，则直接返回B[k-1]。
        如果搜索B[s:e]且s>e，即B搜索完了，则直接返回A[k-1]。



    int findKthNum(int A[], int m, int B[], int n, int k) {
        if (m == 0) return B[k - 1];
        if (n == 0) return A[k - 1];
        int i = m / 2, j = n / 2;
        if (A[i] <= B[j]) {
            if (k > i + j + 1)
                return findKthNum(A + i + 1, m - i - 1, B, n, k - i - 1);
            else
                return findKthNum(A, m, B, j, k);
        } else {
            if (k > i + j + 1)
                return findKthNum(A, m, B + j + 1, n - j - 1, k - j - 1);
            else
                return findKthNum(A, i, B, n, k);
        }
    }
    */
    //log(m) + log(n) 每次丢掉某个数组的一半
    int FindKth(int A[], int aL, int aR, int B[], int bL, int bR, int k) {
        if (aL > aR) return B[bL + k - 1];
        if (bL > bR) return A[aL + k - 1];

        int aMid = (aL + aR) / 2;
        int bMid = (bL + bR) / 2;

        if (A[aMid] <= B[bMid]) {
            if (k <= (aMid - aL) + (bMid - bL) + 1)
                return FindKth(A, aL, aR, B, bL, bMid - 1, k);
            else
                return FindKth(A, aMid + 1, aR, B, bL, bR, k - (aMid - aL) - 1);
        }
        else { // A[aMid] > B[bMid]
            if (k <= (aMid - aL) + (bMid - bL) + 1)
                return FindKth(A, aL, aMid - 1, B, bL, bR, k);
            else
                return FindKth(A, aL, aR, B, bMid + 1, bR, k - (bMid - bL) - 1);
        }
    }

}
