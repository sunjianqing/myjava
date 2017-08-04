package com.jianqing.interview.leetcode16;

import java.util.List;

/**
 * Created by jianqing_sun on 12/9/16.
 *
 * Difficulty: Hard
 */
public class RemoveInvalidParentheses_301 implements Solution {
    @Override
    public void solution() {

    }

    /*
        BFS Solution
        BFS 的思想， 每次多去掉一个括号， 把所有的子字符串放进Queue，进行验证， 如果有符合的， 就不用继续了， 相当于剪枝，
        如果没有符合的，继续去掉一个括号（相比于原字符串， 相当于去掉了两个括号），相当于BFS的又下一层，再进行验证，如果有符合的，
        就不用继续了。一直进行到底

     */
    public List<String> removeInvalidParentheses(String s) {
        return null;
    }

    /*
        DFS Solution
     */

}
