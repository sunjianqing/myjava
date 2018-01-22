package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 11/5/17.
 *
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

 For example,
 Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

 Given word1 = “coding”, word2 = “practice”, return 3.
 Given word1 = "makes", word2 = "coding", return 1.

 双指针，每次遇到任一word ， 就算一次
 */
public class ShortestWordDistance_243 {
    public int shortestDistance(String[] words, String word1, String word2) {
        if(words == null || words.length == 0 ) {
            return 0;
        }

        int p1 = -1;
        int p2 = -1;
        int min = Integer.MIN_VALUE;
        for(int i = 0 ; i < words.length; i++) {
            if(words[i].equals(word1)) {
                p1 = i;
            }
            if(words[i].equals(word2)) {
                p2 = i;
            }

            if(p1 != -1 && p2 != -1){
                min = Math.min(min, Math.abs(p1 - p2));
            }

        }
        return min;
    }
}
