package com.jianqing.interview.leetcode16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jianqing_sun on 12/12/16.
 */
public class PascalsTriangle_118 implements Solution {
    @Override
    public void solution() {

    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        if(numRows == 0)
            return res;
        res.add(Arrays.asList(1));

        int i = 1;
        while( i < numRows){
            List<Integer> lastRow = res.get(i - 1);
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);
            for ( int j = 0; j < lastRow.size() - 1; j++){
                currentRow.add(lastRow.get(j) + lastRow.get(j+1));
            }
            currentRow.add(1);
            res.add(currentRow);
            i++;
        }

        return res;
    }
}
