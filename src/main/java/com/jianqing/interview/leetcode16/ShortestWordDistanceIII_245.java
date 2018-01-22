package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 1/18/18.
 * This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.
 * <p>
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * <p>
 * word1 and word2 may be the same and they represent two individual words in the list.
 * <p>
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * <p>
 * Given word1 = “makes”, word2 = “coding”, return 1.
 * Given word1 = "makes", word2 = "makes", return 3.
 */
public class ShortestWordDistanceIII_245 {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if (words == null || words.length < 1 || word1 == null || word2 == null) {
            return 0;
        }

        int p1 = -1, p2 = -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            int pre = p1;
            if (words[i].equals(word1)) {
                p1 = i;
            }
            if (words[i].equals(word2)) {
                p2 = i;
            }

            if (p1 != -1 && p2 != -1) {
                if (word1.equals(word2) && pre != -1 && pre != p1) {
                    // 这时p1, p2 相等， pre 就存了以前的word 的index
                    res = Math.min(res, Math.abs(p2 - pre));
                } else if (p1 != p2) {
                    // cover 了 word1 word2 不等的情况
                    res = Math.min(res, Math.abs(p2 - p1));
                }
            }
        }

        return res;
    }
}
