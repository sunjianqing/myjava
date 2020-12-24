package com.jianqing.interview.facebook.lc20;

import java.util.*;

/**
 * https://youtu.be/pYKGRZwbuzs
 *
 * DFS
 * Word Break II 这个要所有的结果.  就是得验证当前子字符串在不在dict之后， 递归调用剩下的， 递归回来的的所有结果，应该一个个的与当前子串组成结果
 *https://leetcode.com/problems/word-break-ii/discuss/44167/My-concise-JAVA-solution-based-on-memorized-DFS
 */
public class LC_140_WordBreakII {

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }
        Map<String, List<String>> used = new HashMap<>();
        Set<String> dict = new HashSet<String>(wordDict);

        return dfs(s, dict, used);
    }

    public List<String> dfs(String s, Set<String> dict, Map<String, List<String>> used) {
        if (s.length() == 0) {
            return null;
        }
        if (used.containsKey(s)) {
            return used.get(s);
        }

        List<String> res = new LinkedList<>();
        for (int i = 1; i <= s.length(); i++) {
            String subStr = s.substring(0, i);
            List<String> nextRes = null;
            if (dict.contains(subStr)) {
                nextRes = dfs(s.substring(i), dict, used);
                if(nextRes == null) {
                    res.add(subStr); // subStr 就是个答案， 因为下面 s length 是 0 return 了null，
                }
                else {
                    for (String ns : nextRes) {
                        res.add(subStr + " " + ns);
                    }
                }
            }
        }
        used.put(s, res);
        return res;
    }
}
