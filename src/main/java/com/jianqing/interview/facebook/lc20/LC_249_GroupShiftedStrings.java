package com.jianqing.interview.facebook.lc20;

import java.util.*;

/**
 *
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
 *
 * "abc" -> "bcd" -> ... -> "xyz"
 * Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
 *
 * For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 * Return:
 *
 * [
 *   ["abc","bcd","xyz"],
 *   ["az","ba"],
 *   ["acef"],
 *   ["a","z"]
 * ]
 *
 * 找到一种encoder 来生成hash key
 * <p>
 * encoder : 找到每个字符串的第一个字符离a的距离， 然后其他的每个字符减掉那个距离， 如果小于0， 就再加个26
 * <p>
 * eg. 怎么验证 abc 跟 yza 是同一个shifted string ?
 * y - 'a' = 24
 * so z- 24 => b, a -24 = -23 再加26 = 3 => c
 * 所以 abc yza 是同一个shifted string
 */
public class LC_249_GroupShiftedStrings {

    public List<List<String>> solution(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            String encodeStr = encoder(s);
            if (map.containsKey(encodeStr)) {
                map.get(encodeStr).add(s);
            }
            else {
                map.put(encodeStr, Arrays.asList(s));
            }
        }

        List<List<String>> res = new ArrayList<>();
        map.forEach( (k, sameGroupStrs) -> {res.add(sameGroupStrs);});

        return res;
    }

    private String encoder(String s) {
        StringBuilder sb = new StringBuilder();

        int dist = s.charAt(0) - 'a';
        sb.append('a');
        for (int i = 1; i < s.length(); i++) {
            int cur = s.charAt(i) - 'a' - dist;
            if (cur < 0) {
                cur += 26;
            }
            sb.append('a' + cur);
        }
        return sb.toString();
    }
}
