package com.jianqing.interview.leetcode16;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianqingsun on 11/9/16.
 */
public class FizzBuzz_412 implements Solution {
    public static void main(String[] args) {
        FizzBuzz_412 fizzBuzz_412 = new FizzBuzz_412();
        fizzBuzz_412.solution();
    }

    @Override
    public void solution() {
        this.fizzBuzz(8);
    }


    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList();
        if (n == 0)
            return res;

        for (int i = 1; i <= n; i++) {

            if (i % 3 != 0 && i % 5 != 0) {
                res.add(String.valueOf(i));
            } else if (i % 3 == 0 && i % 5 != 0) {
                res.add("Fizz");
            } else if (i % 5 == 0 && i % 3 != 0) {
                res.add("Buzz");
            } else {
                res.add("FizzBuzz");
            }
        }

        return res;

    }
}
