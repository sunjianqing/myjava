package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 4/18/17.
 * <p>
 * 找到字符 以 'a','b' ... 'z'结尾的最长子串的长度， 再累加起来
 */
public class UniqueSubstringsinWraparoundString_467 {
    public int findSubstringInWraproundString(String p) {
        if (p == null || p.length() == 0)
            return 0;

        int len = p.length();
        int[] count = new int[26];

        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i - 1) - p.charAt(i) == 25)) {
                maxLen++;
            } else {
                maxLen = 1;
            }

            int index = p.charAt(i) - 'a';
            count[index] = Math.max(count[index], maxLen);
        }

        int sum = 0;
        for (int i = 0; i < count.length; i++) {
            sum += count[i];
        }

        return sum;

    }

}
