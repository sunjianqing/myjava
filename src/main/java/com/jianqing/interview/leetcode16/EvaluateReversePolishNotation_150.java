package com.jianqing.interview.leetcode16;

import java.util.Stack;

/**
 * Created by jianqingsun on 5/31/17.
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p>
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * <p>
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvaluateReversePolishNotation_150 {
    public static void main(String[] args) {
        EvaluateReversePolishNotation_150 ev = new EvaluateReversePolishNotation_150();
        ev.evalRPN(new String[]{"0","3","/"});
    }
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        int len = tokens.length;
        stack.push(Integer.valueOf(tokens[0]));
        for (int i = 1; i < len; i++) {
            switch (tokens[i]) {
                case "+" : {
                    int m = stack.pop();
                    int n = stack.pop();
                    stack.push(m + n);
                    break;
                }
                case "-" :{
                    int m = stack.pop();
                    int n = stack.pop();
                    stack.push(n -m);
                    break;
                }
                case "*" :{
                    int m = stack.pop();
                    int n = stack.pop();
                    stack.push(n * m);
                    break;
                }
                case "/" :{
                    int m = stack.pop();
                    int n = stack.pop();
                    stack.push((int) n / m);
                    break;
                }
                default: {
                    stack.push(Integer.valueOf(tokens[i]));
                    break;
                }
            }

        }

        int res = stack.pop();
        return res;
    }
}
