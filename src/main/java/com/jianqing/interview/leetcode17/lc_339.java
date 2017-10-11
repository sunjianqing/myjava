package com.jianqing.interview.leetcode17;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by jianqing_sun on 10/9/17.
 * Nested List Weight Sum
 *
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

 Each element is either an integer, or a list -- whose elements may also be integers or other lists.

 Example 1:
 Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)

 Example 2:
 Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)

 */

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer,
    // rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds,
    // if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds,
    // if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}


public class lc_339 {

    // 递归
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }

    public int helper(List<NestedInteger> nestedList, int depth){
        if (nestedList == null || nestedList.size() == 0)
            return 0;

        int sum = 0;
        for(NestedInteger ele : nestedList) {
            if (ele.isInteger()) {
                sum += ele.getInteger() * depth;
            } else {
                sum += helper(ele.getList(), depth + 1);
            }
        }

        return sum;
    }

    public int depthSum2(List<NestedInteger> nestedList) {
        // Write your code here
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        int sum = 0;
        Queue<NestedInteger> queue = new LinkedList<NestedInteger>();
        for (NestedInteger nestedInt : nestedList) {
            queue.offer(nestedInt);
        }

        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                NestedInteger nestedInt = queue.poll();
                if (nestedInt.isInteger()) {
                    sum += nestedInt.getInteger() * depth;
                } else {
                    for (NestedInteger innerInt : nestedInt.getList()) {
                        queue.offer(innerInt);
                    }
                }
            }
        }
        return sum;
    }
}
