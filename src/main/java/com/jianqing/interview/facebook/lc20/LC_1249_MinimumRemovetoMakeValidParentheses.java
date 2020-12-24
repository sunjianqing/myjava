package com.jianqing.interview.facebook.lc20;

import java.util.Stack;

/**
 * 用个stack记录当前可能去掉的左括号的位置
 * 如果碰到右括号， stack不为空的时候， 就pop
 * 如果为空，就可以把这个右括号换成一个特殊字符#，
 * 最后扫一遍stack，stack里所有左括号都换成特殊字符#
 * 最后字符串里所有#删掉
 *
 * Minimum Remove to Make Valid Parentheses
 *
 */
public class LC_1249_MinimumRemovetoMakeValidParentheses {

    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        if (s == null || s.isEmpty()) {
            return "";
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(i);
            }
            else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                else {
                    sb.setCharAt(i, '#');
                }
            }
        }

        while(!stack.isEmpty()) {
            int removeLeftIndex = stack.pop();
            sb.setCharAt(removeLeftIndex, '#');
        }

        StringBuilder res = new StringBuilder();
        String replacedStr = sb.toString();
        for (int i = 0; i < replacedStr.length(); i++) {
            if (replacedStr.charAt(i) != '#') {
                res.append(replacedStr.charAt(i));
            }
        }

        return res.toString();
    }
}
