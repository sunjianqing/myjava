package com.jianqing.interview.leetcode16;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by jianqing_sun on 12/9/16.
 *
 * Remove Invalid Parentheses
 *
 *  <p>
 * Difficulty: Hard
 *
 * https://leetcode.com/problems/remove-invalid-parentheses/discuss/75027/Easy-Short-Concise-and-Fast-Java-DFS-3-ms-solution
 *
 *
 */
public class RemoveInvalidParentheses_301 implements Solution {
    @Override
    public void solution() {

    }

    public static void main(String[] args) {
        RemoveInvalidParentheses_301 rip = new RemoveInvalidParentheses_301();
        rip.removeInvalidParenthesesDFS("()())()");
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
        记住这个方法吧， 好记

        先找到需要删除的 （ 跟 ） 的数量
        然后DFS

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

        if (i == s.length() ) {
            if (rmL == 0 && rmR == 0 && open == 0) {
                res.add(sb.toString());
            }
            return;
        }

        char c = s.charAt(i);
        if (c == '(') {
            // 一定得先写这行sb 不append 的
            dfs(s, i + 1, res, sb, rmL - 1, rmR, open); // remove
            dfs(s, i + 1, res, sb.append(c), rmL, rmR, open + 1); // keep
        } else if (c == ')') {
            // 一定得先写这行sb 不append 的
            dfs(s, i + 1, res, sb, rmL, rmR - 1, open); // remove, open 还是那么多
            dfs(s, i + 1, res, sb.append(c), rmL, rmR, open - 1); // keep ， open 可以减1
        } else {
            dfs(s, i + 1, res, sb.append(c), rmL, rmR, open);
        }


        sb.setLength(len); //reset back to decision point -- remove last char of sb

    }


    // =====2020/11/24==========

    public List<String> removeInvalidParentheses(String s) {
        List<String> output = new ArrayList<>();
        removeHelper(s, output, 0, 0, '(', ')');
        return output;
    }

    public void removeHelper(String s, List<String> output, int iStart, int jStart, char openParen, char closedParen) {
        int numOpenParen = 0, numClosedParen = 0;
        for (int i = iStart; i < s.length(); i++) {
            if (s.charAt(i) == openParen) numOpenParen++;
            if (s.charAt(i) == closedParen) numClosedParen++;
            if (numClosedParen > numOpenParen) { // We have an extra closed paren we need to remove
                for (int j = jStart; j <= i; j++) // Try removing one at each position, skipping duplicates
                    if (s.charAt(j) == closedParen && (j == jStart || s.charAt(j - 1) != closedParen))
                        // Recursion: iStart = i since we now have valid # closed parenthesis thru i. jStart = j prevents duplicates
                        removeHelper(s.substring(0, j) + s.substring(j + 1, s.length()), output, i, j, openParen, closedParen);
                return; // Stop here. The recursive calls handle the rest of the string.
            }
        }
        // No invalid closed parenthesis detected. Now check opposite direction, or reverse back to original direction.
        String reversed = new StringBuilder(s).reverse().toString();
        if (openParen == '(')
            removeHelper(reversed, output, 0, 0, ')','(');
        else
            output.add(reversed);
    }


}
