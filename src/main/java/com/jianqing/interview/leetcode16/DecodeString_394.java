package com.jianqing.interview.leetcode16;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by jianqingsun on 12/29/16.
 */
public class DecodeString_394 implements Solution {
    public static void main(String[] args) {
        DecodeString_394 solution = new DecodeString_394();
        solution.solution();
    }

    @Override
    public void solution() {
        this.decodeString("100[leetcode]");
    }

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
