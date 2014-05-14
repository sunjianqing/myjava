package com.jianqing.interview.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by jianqsun on 5/11/14.
 */
public class ValidParentheses {
    public boolean isValid(String s){
        if(s == null){
            return false;
        }

        char[] chars = s.toCharArray();
        Stack<Character> charStack = new Stack<Character>();
        charStack.push(chars[0]);

        for(int i = 1 ; i < chars.length ; i++){
            switch (chars[i]){
                case '(': // parenthese
                    charStack.push(chars[i]);
                    break;
                case '{': // brace
                    charStack.push(chars[i]);
                    break;
                case '[': // bracket
                    charStack.push(chars[i]);
                    break;
                case ')':
                    if( !charStack.isEmpty() && charStack.peek() == '('){
                        charStack.pop();
                    }
                    else
                        charStack.push(chars[i]);
                    break;
                case '}':
                    if( !charStack.isEmpty() && charStack.peek() == '{'){
                        charStack.pop();
                    }
                    else
                        charStack.push(chars[i]);
                    break;
                case ']':
                    if(!charStack.isEmpty() && charStack.peek() == '['){
                        charStack.pop();
                    }
                    else
                        charStack.push(chars[i]);
                    break;
            }
        }

        if(charStack.isEmpty())
            return true;
        else
            return false;
    }

    public boolean isValid2(String s) {
        char[] charArray = s.toCharArray();

        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<Character>();

        for (Character c : charArray) {
            if (map.keySet().contains(c)) {
                stack.push(c);
            } else if (map.values().contains(c)) {
                if (!stack.isEmpty() && map.get(stack.peek()) == c) {
                    stack.pop();
                } else {
                    return false; // return directly
                }
            }
        }
        return stack.isEmpty();
    }
}
