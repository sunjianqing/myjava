package com.jianqing.interview.facebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by jianqing_sun on 8/8/17.
 */
public class RemoveInvalidParentheses_F {
    public List<String> removeInvalidParentheses(String s) {
        int rmL = 0, rmR = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                rmL++;
            } else if (s.charAt(i) == ')') {
                if (rmL > 0) {
                    rmL--;
                } else {
                    rmR++;
                }
            }
        }

        Set<String> res = new HashSet<>();
        dfs(s, 0, res, new StringBuilder(), rmL, rmR, 0);

        return new ArrayList<>(res);
    }

    public void dfs(String s, int i, Set<String> res, StringBuilder sb, int rmL, int rmR, int open) {
        if (rmL < 0 || rmR < 0 || open < 0) {
            return;
        }

        int len = sb.length();

        if (open == 0) {
            res.add(sb.toString());
            return;
        } else {
            char c = s.charAt(i);
            if (c == '(') {
                dfs(s, i + 1, res, sb.append(c), rmL, rmR, open + 1); // keep
                dfs(s, i + 1, res, sb, rmL - 1, rmR, open); // remove
            } else if (c == ')') {
                dfs(s, i + 1, res, sb.append(c), rmL, rmR, open - 1); // keep
                dfs(s, i + 1, res, sb, rmL, rmR - 1, open); // remove

            } else {
                dfs(s, i + 1, res, sb.append(c), rmL, rmR, open);
            }
        }

        sb.setLength(len); //reset back to decision point -- remove last char of sb

    }
}
