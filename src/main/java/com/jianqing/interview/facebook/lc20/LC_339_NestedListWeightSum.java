package com.jianqing.interview.facebook.lc20;

import java.util.List;

public class LC_339_NestedListWeightSum {

    public int depthSum(List<NestedInteger> nestedList) {
        return ds(1, nestedList);
    }
    private int ds(int level, List<NestedInteger> nestedList) {
        int sum = 0;
        for (NestedInteger ni:nestedList) {
            if (ni.isInteger()) {
                sum +=level * ni.getInteger();
            }
            else {
                sum +=ds(level + 1, ni.getList());
            }
        }
        return sum;
    }
}

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}