package com.jianqing.interview.leetcode16;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianqing_sun on 3/12/18.
 * Factor Combinations
 *
 * Examples:
 input: 1
 output:

 []
 input: 37
 output:

 []
 input: 12
 output:

 [
 [2, 6],
 [2, 2, 3],
 [3, 4]
 ]
 input: 32
 output:

 [
 [2, 16],
 [2, 2, 8],
 [2, 2, 2, 4],
 [2, 2, 2, 2, 2],
 [2, 4, 4],
 [4, 8]
 ]
 */
public class FactorCombinations_254 {
    public static void main(String[] args) {
        FactorCombinations_254 f = new FactorCombinations_254();
        f.getFactors(32);
    }
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();

        if (n <= 1) {
            return res;
        }

        List<Integer> cur = new ArrayList<>();

        dfs(n, cur, res, 2);
        System.out.println(res);
        return res;
    }

    private void dfs(int n, List<Integer> cur, List<List<Integer>> res, int start) {
        if (n == 1) {
            if(cur.size() != 1){// 大于1 才加入结果
                res.add(new ArrayList<>(cur));
            }
            return;
        }

        int i = start;
        for (; i <= n; i++) {
            if (n % i == 0) {
                cur.add(i);
                dfs(n / i, cur, res, i);
                cur.remove(cur.size() - 1);
            }
        }

        return;

    }


}
