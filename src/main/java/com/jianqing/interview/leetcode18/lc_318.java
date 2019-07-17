package com.jianqing.interview.leetcode18;

/**
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
 * <p>
 * Example 1:
 * <p>
 * Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * Output: 16
 * Explanation: The two words can be "abcw", "xtfn".
 * <p>
 * 因为只含有小写字母，一个int 的bit （32位） 就够存所有每一个string 的所有字符出现与否了
 */

public class lc_318 {
    public int maxProduct(String[] words) {

        int n = words.length;

        int[] bitValues = new int[words.length];

        for (int i = 0; i < n; i++) {
            String word = words[i];


            int bit = 0;

            for (char c : word.toCharArray()) {
                bit |= 1 << (c - 'a');
            }

            bitValues[i] = bit;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if( (bitValues[i] & bitValues[j]) == 0){
                    // 所有bit 位置与 后 = 0 ， 说明都不相同
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }

        return max;

    }
}
