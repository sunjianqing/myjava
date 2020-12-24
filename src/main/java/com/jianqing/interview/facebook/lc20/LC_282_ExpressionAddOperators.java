package com.jianqing.interview.facebook.lc20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://youtu.be/AXNb-stFNb4
 * DFS backtrack
 */
public class LC_282_ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        if (num == null || num.length() == 0) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();
        dfs(res, num, "", target, 0, 0, 0);

        return res;
    }

    private void dfs(List<String> res, String s, String path, int target, int index, long cal, long mul) {
        if (index == s.length()) {
            if (cal == target) {
                res.add(path);
            }
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (i != index && s.charAt(index) == '0') break; // 大于1位的数，不能以0 开头

            long cur = Long.parseLong(s.substring(index, i + 1));
            if (index == 0) { // 初始操作数
                dfs (res, s, path + cur, target,  i + 1, cur, cur);
            }
            else {
                dfs (res, s, path + "+" + cur, target, i + 1, cal + cur, cur);
                dfs (res, s, path + "-" + cur, target, i + 1, cal - cur, -cur);  // 到下步， 遇到*， 要退的时候

                dfs (res, s, path + "*" + cur, target, i + 1, cal - mul + mul * cur, mul * cur);
                // 比如算过了 3+2 = 5 , 把cal=5 传进来了， mul=2, 现在要尝试 3+2*4, (cur=4), 就得先-2， 再+2*4
            }
        }
    }
}
