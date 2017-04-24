package com.jianqing.interview.leetcode16;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianqing_sun on 4/13/17.
 * DFS 回溯 经典模型
 */
public class PalindromePartitioning_131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();

        List<String> curPartition = new ArrayList<>();
        dfs( 0, s, res, curPartition);
        return res;
    }

    private void dfs(int start, String source, List<List<String>> res, List<String> curPartition) {
        if (start == source.length()) {
            res.add(new ArrayList<String>(curPartition));
            return;
        }
        int len = source.length();
        for (int i = start; i < len; i++) {
            String subStr = source.substring(start, i + 1);
            if (!isPalindrome(subStr))
                continue;

            curPartition.add(subStr);
            dfs(i + 1, source, res, curPartition);
            curPartition.remove(curPartition.size() - 1);
        }
    }

    private boolean isPalindrome(String subStr) {
        int i = 0, j = subStr.length() - 1;
        while (i < j) {
            if (subStr.charAt(i) != subStr.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;
    }

}
