package com.jianqing.interview.leetcode16;

import java.util.List;

/**
 * Created by jianqingsun on 3/6/18.
 * <p>
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 * <p>
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * <p>
 * Example 1:
 * Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)
 */
public class NestedListWeightSum_339 {

    public int depthSum(List<NestedInteger> nestedList) {
        int res = 0;
        if (nestedList == null || nestedList.size() == 0) {
            return res;
        }

        res = helper(nestedList, 1);
        return res;
    }

    private int helper(List<NestedInteger> list, int depth){
        int sum = 0;
        for(NestedInteger n : list){
            if(n.isInteger()){
                sum += depth * n.getInteger();
            }
            else{
                sum += helper(n.getList(), depth+1);
            }
        }
        return sum;
    }

    private interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

}
