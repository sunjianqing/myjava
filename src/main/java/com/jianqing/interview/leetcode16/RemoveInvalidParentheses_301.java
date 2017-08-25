package com.jianqing.interview.leetcode16;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by jianqing_sun on 12/9/16.
 *
 * Difficulty: Hard
 */
public class RemoveInvalidParentheses_301 implements Solution {
    @Override
    public void solution() {

    }

    /*
        BFS Solution
        BFS 的思想， 每次多去掉一个括号， 把所有的子字符串放进Queue，进行验证， 如果有符合的， 就不用继续了， 相当于剪枝，
        如果没有符合的，继续去掉一个括号（相比于原字符串， 相当于去掉了两个括号），相当于BFS的又下一层，再进行验证，如果有符合的，
        就不用继续了。一直进行到底

     */
    public List<String> removeInvalidParenthesesBFS(String s) {
        return null;
    }

    /*
        DFS Solution
     */

    public List<String> removeInvalidParenthesesDFS(String s) {
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

        if (i == s.length()) {
            if (rmL == 0 && rmR == 0 && open == 0) {
                res.add(sb.toString());
            }
            return;
        }

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


        sb.setLength(len); //reset back to decision point -- remove last char of sb

    }


}
