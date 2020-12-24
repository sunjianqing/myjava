package com.jianqing.interview.facebook.lc20;

import java.util.*;

/**
 * 会联想到word break 怎么做的， 用的DP， 看单词是不是被dict里拼起来， dp[i] 代表到第i个字符能拼起来
 * <p>
 * DP
 * <p>
 * 可以对每个单词，在整个words里去掉自身做word break
 *
 * ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 *
 */
public class LC_472_ConcatenatedWords {

    public static void main(String[] args) {
        LC_472_ConcatenatedWords lc = new LC_472_ConcatenatedWords();
        lc.findAllConcatenatedWordsInADict(new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"});

    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        if (words == null || words.length == 0)
            return new ArrayList<>();

        Set<String> dict = new HashSet<>(Arrays.asList(words));
        Set<String> tmpSet = new HashSet<>(Arrays.asList(words));

        List<String> res = new ArrayList<>();

        for (String w : dict) {
            tmpSet.remove(w);
            boolean yes = canBreak(w, tmpSet);
            if (yes && !w.isEmpty()) {
                res.add(w);
            }
            tmpSet.add(w);

        }
        return res;
    }

    public boolean canBreak(String w, Set<String> dict) {

        boolean[] dp = new boolean[w.length() + 1];
        dp[0] = true;

        for (int i = 0; i < w.length(); i++) {
            String cur = w.substring(0, i + 1);
            if (dict.contains(cur) || dp[i +1]) {
                dp[i + 1] = true;
                for (int j = i + 1; j < w.length(); j++) {
                    if (dp[j+1] ==  true) continue;

                    String tmp = w.substring(i + 1, j + 1);
                    if (dict.contains(tmp)) {
                        dp[j+1] = true;
                    }
                }
            }
        }

        return dp[w.length()];
    }


}