package com.jianqing.interview.simple;

/**
 * Created by jianqing_sun on 12/9/16.
 */
public class ValidParentheses {
    public static void main(String[] args) {
      ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValid(")("));
    }

    private boolean isValid(String s) {
        int leftCount = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                leftCount++;
            } else if (c == ')') {
                leftCount--;
            }
            if(leftCount < 0) {
                return false;
            }
        }

        return leftCount == 0;
    }
}
