package com.jianqing.interview.leetcode16;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianqingsun on 12/28/16.
 */
public class DifferentWaystoAddParentheses_241 implements Solution {
    @Override
    public void solution() {

    }

    public List<Integer> diffWaysToCompute(String input) {

        List<Integer> res = new ArrayList<Integer>();
        for ( int i = 0 ; i < input.length(); i++){
            if(isOperator(input.charAt(i))){
                char operator = input.charAt(i);
                List<Integer> left = diffWaysToCompute(input.substring(0,i));

                List<Integer> right = diffWaysToCompute(input.substring(i+1, input.length()));

                /*
                divide and conquer
                只关心当前符号左右可能生成的数
                 */

                for ( int m = 0 ; m<left.size() ;  m++){
                    for ( int n = 0 ; n < right.size(); n++ )
                        res.add(calculate(left.get(m), right.get(n), operator));
                }
            }
        }

        if( res.size() == 0){
            // single number
            res.add(Integer.valueOf(input));
        }

        return res;
    }

    public boolean isOperator(char c) {
        if (c == '+' || c == '-' || c == '*')
            return true;
        return false;
    }

    public int calculate(int num1, int num2, char operator) {
        int result = 0;
        switch(operator) {
            case '+' : result = num1 + num2;
                break;

            case '-' : result = num1 - num2;
                break;

            case '*' : result = num1 * num2;
                break;
        }
        return result;
    }

}
