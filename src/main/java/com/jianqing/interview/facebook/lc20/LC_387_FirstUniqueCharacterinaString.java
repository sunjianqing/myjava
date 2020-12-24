package com.jianqing.interview.facebook.lc20;

import java.util.HashMap;
import java.util.Map;

/**
 * 自己把问题想复杂了， 想成双指针了， 各种corner case就比较难处理
 *
 * 这题可以用个hashmap，统计下频率
 * 然后再扫一遍，找最先frequency 是1 的。。。。
 *
 *
 */
public class LC_387_FirstUniqueCharacterinaString {
    public static void main(String[] args) {
        LC_387_FirstUniqueCharacterinaString lc = new LC_387_FirstUniqueCharacterinaString();
        lc.firstUniqChar("aadadaad");
    }
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;

        Map<Character, Integer> map = new HashMap<>();

        int res = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) == 1 && res == -1) {
                res = i;
            }
            else {
                if (res != -1 && c == s.charAt(res)) {
                    int j = res + 1;
                    while (j < i) {
                        if (map.get(s.charAt(j)) == 1){
                            res = j;
                            break;
                        }
                        else{
                            j++;
                        }
                    }
                    if (j == i) { // 如果i 之前所有字符都重复， res 就先设 -1
                        res = -1;
                    }
                }
            }
        }

        return res;

    }
}
