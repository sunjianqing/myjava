package com.jianqing.interview.facebook.lc20;

import java.util.Stack;

/**
 * 可以用个stack
 *
 * if ( , push it to stack
 * if ),  check if there is a matching '(' on top of stack; if no, increase the counter by 1; if yes, pop it out;
 * after the loop, count in the un-matched characters remaining in the stack.
 */
public class LC_921_MinimumAddtoMakeParenthesesValid {
    public int minAddToMakeValid(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }

        Stack<Character> stack = new Stack<Character>();

        int i = 0;
        int right = 0;
        while (i < S.length()) {
            Character c = S.charAt(i);
            if (c == '(') {
                stack.push(c);
            }
            else if (!stack.isEmpty() && stack.peek() == '(') {
               stack.pop();
            }
            else {
                right ++;
            }
            i++;
        }

        return right + stack.size();
    }
}
