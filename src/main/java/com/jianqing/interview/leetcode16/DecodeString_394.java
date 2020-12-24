package com.jianqing.interview.leetcode16;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by jianqingsun on 12/29/16.
 *
 * 可以用两个stack， 一个记录重复的次数的num stack， 一个记录当前的应该重复的字符串
 *
 */
public class DecodeString_394 implements Solution {
    public static void main(String[] args) {
        DecodeString_394 solution = new DecodeString_394();
        solution.solution();
    }


    public String decodeString2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();

        int idx = 0;
        String res = ""; // 定义一个变量用来track当前的字符串
        while(idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                numStack.push(count);
            }
            else if (s.charAt(idx) == '['){ // 碰到左括号， 把当前记录的字符串放进stack
                strStack.push(res);
                res = ""; // 然后重置res
                idx++;
            }
            else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder (strStack.pop());

                int repeatTimes = numStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }
            else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }



    @Override
    public void solution() {
        this.decodeString("100[leetcode]");
    }

    // 不好懂
    public String decodeString(String s) {
        if (s.length() == 0)
            return "";

        Stack<Character> stack = new Stack();
        int i = 0;
        StringBuilder res = new StringBuilder();

        while (i < s.length()) {

            if (stack.isEmpty() && (s.charAt(i) - '0') > 9) {
                res.append(s.charAt(i));
                i++;
                continue;
            }

            if (s.charAt(i) != ']') {
                stack.push(s.charAt(i));
            } else {
                char c = stack.pop();
                List<Character> cl = new LinkedList<>();

                while (c != '[') {
                    cl.add(0, c);
                    c = stack.pop();
                }

                StringBuilder dupStr = new StringBuilder();

                for (int j = 0; j < cl.size(); j++) {
                    dupStr.append(cl.get(j));
                }

                int m = 0 ;
                int cnum = stack.peek() - '0';

                double dumNum = 0;

                while(cnum >=0 && cnum <= 9){
                    dumNum += Math.pow(10, m++)*cnum ;
                    stack.pop();
                    if(!stack.isEmpty())
                        cnum = stack.peek() - '0';
                    else
                        break;
                }

                StringBuilder sb = new StringBuilder();
                while (dumNum-- > 0) {
                    sb.append(dupStr.toString());

                }

                if (stack.isEmpty()) {
                    res.append(sb.toString());
                } else {
                    for (int k = 0; k < sb.length(); k++) {
                        stack.push(sb.charAt(k));
                    }
                }


            }

            i++;
        }

        return res.toString();
    }
}
