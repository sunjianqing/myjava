package com.jianqing.interview.amazon;

/**
 * Created by jianqing_sun on 2/6/18.
 */
// "(9 - 1) / 4 + 2 * 3" => 8

// (9 - 1) / 4 + 2 + 3

//(9 - 1) / 4 + 2 * 3 * 3

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Evernote {
    public static void main(String[] args) {
        Evernote s = new Evernote();
        int res = s.compute("(9 - 1) / 4 + 2 * 3");
        System.out.println(res);

    }

    public int compute(String s){
        char[] c = s.toCharArray();

        Stack<Integer> values = new Stack<Integer>();

        Stack<Character> ops = new Stack<Character>();

        for(int i = 0; i < c.length; i++){
            if(c[i] == ' '){
                continue;
            }

            if(c[i] == '('){
                ops.push(c[i]);
            }
            else if(c[i] == ')'){
                // do all computation between (), then pop (

                while(ops.peek() != '('){
                    char co = ops.pop();
                    int right = values.pop();
                    int left = values.pop();

                    // do a computation
                    int res = compute(co, left, right);
                    values.push(res);

                }

                ops.pop();
            }
            else if(c[i] >= '0' && c[i] <= '9'){
                // parse string

                int start = i;
                while(i < c.length && c[i] >= '0' && c[i] <= '9'){
                    i++;
                }
                values.push(Integer.valueOf(s.substring(start, i)));
                i--;
            }
            else if(c[i] == '+' || c[i] == '-' || c[i] == '*' || c[i] == '/'){
                // check ops peek with current op

                while(!ops.isEmpty() && compare(c[i], ops.peek())){
                    char co = ops.pop();
                    int right = values.pop();
                    int left = values.pop();

                    // do a computation
                    int res = compute(co, left, right);
                    values.push(res);
                }

                ops.push(c[i]);
            }
        }

        return values.pop();
    }

    private int compute(char c, int left, int right){
        // do + - * /

        switch(c){
            case '+':
                return left + right;
            case '-':
                return left - right;
            case '*':
                return left * right;
            case '/':
                return left / right;

        }

        return 0;
    }

    // compare 2 operators
    private boolean compare(char c1, char c2){
        if(c2 == '(' || c2 == ')')
            return false;

        if((c1 == '*' || c1 == '/') && (c2 == '+' || c2 == '-'))
            return false;

        return true;
    }
}
