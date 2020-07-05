package com.jianqing.interview.leetcode_category.double_pointer;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Reverse Vowels of a String
 */
public class LC_345 {
    private static final HashSet<Character> vowels = new HashSet<Character>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {
        if (s == null) {
            return null;
        }
        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()];

        while (i <= j) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);

            if(!vowels.contains(c1)) {
                result[i++] = c1;
            }
            else if(!vowels.contains(c2)) {
                result[j--] = c2;
            }
            else {
                // swap
                result[i++] = c2;
                result[j--] = c1;
            }
        }

        return new String(result);
    }
}
