package com.jianqing.interview.facebook.lc20;

import java.util.Stack;

public class LC_844_BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {

        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != '#') {
                stackS.push(S.charAt(i));
            }
            else {
                if(!stackS.isEmpty()) stackS.pop();
            }
        }

        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) != '#') {
                stackT.push(T.charAt(i));
            }
            else {
                if(!stackT.isEmpty()) stackT.pop();
            }
        }

        while(!stackS.isEmpty() && !stackT.isEmpty()) {
            if (stackS.pop() != stackT.pop()) return false;
        }

        if (!stackS.isEmpty() || !stackT.isEmpty()) return false;

        return true;
    }
}
