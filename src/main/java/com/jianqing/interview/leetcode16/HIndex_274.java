package com.jianqing.interview.leetcode16;

import java.util.Arrays;

/**
 * Created by jianqingsun on 4/8/17.
 */
public class HIndex_274 {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;
        Arrays.sort(citations);

        int h = 0;
        int n = citations.length -1 ;
        if (citations[n] > 0) {

            for ( int i = 0 ; i < citations.length ; i++) {
                if( citations[n-i] >= h ){
                    h++;
                }
            }
        }

        return h;

    }

    // 牛逼解法， O(n)
    public int hIndex2(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;

        int n = citations.length;
        int[] cnt = new int[n+1];

        for ( int i = 0 ; i < n ; i++) {
            if(citations[i] >= n){
                // 所有citation number 大于 paper 总数的， 都记录在 cnt[n]里
                cnt[n]++;
            }
            else {
                cnt[citations[i]]++;
            }
        }

        int tot = 0 ;  // 这里很关键 total number of papers with more than i citations
        for ( int i = n ; i>=0 ; i--){
            // i（hindex 的可能值)，一直降下去，tot一直增下去， 找到"重叠的"时候 ）
            tot = tot + cnt[i];
            if(tot >= i){
                return i; // 这里很关键， 这里可以直接返回， 再继续，i 就变小了。 这里已经找到了最大的i，
            }
        }

        return 0;

    }
}
