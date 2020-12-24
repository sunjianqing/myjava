package com.jianqing.interview.facebook.lc20;

/**
 * Sliding window
 * <p>
 * 先把0 - 到 s1 长度的 字符串 都"放进" map， 然后移动窗口， 每次移动的时候s2里移除的那个字符的hashmap 的value +1
 * 每次都判断整个所有hashmap里的key 的 value 是不是都等于 0
 * <p>
 * 因为 The input strings only contain lower case letters.
 * hashmap 可用 数组
 *
 * 不在s1 的字符 照样做 ++ ， -- 这些操作， 随着窗口移动， 会去掉的， 总归会归0
 */
public class LC_567_PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 > len2) return false;
        int[] countMap = new int[26];

        for (int i = 0; i < len1; i++) {
            countMap[s1.charAt(i) - 'a'] ++;
            countMap[s2.charAt(i) - 'a'] --;
        }

        if (allZero(countMap)) return true;

        for (int i = len1; i < len2; i++) {
            countMap[s2.charAt(i) - 'a'] --; // 窗口右边新进了一个字符
            countMap[s2.charAt(i - len1) - 'a'] ++; // 窗口左边移走了一个字符， 需要匹配的就多一个， 所以++

            if (allZero(countMap)) return true;
        }

        return false;
    }

    private boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
}
