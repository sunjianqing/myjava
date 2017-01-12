package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 1/1/17.
 */
public class LongestRepeatingCharacterReplacement_424 implements Solution {

    @Override
    public void solution() {

    }

    /*/
        滑动窗口 sliding window
        窗口宽度从1 开始， 如果窗口宽度减去窗口里出现次数最多的字符 小于等于K 意味着， 可以替换掉那些非出现最多的字符， 已达到最大子字符串长度
        如果窗口宽度减去窗口里出现次数最多的字符 大于K， 那应该缩小1个单位的窗口宽度， 再判断
        算法可以在O(n) 完成
     */
    public int characterReplacement(String s, int k) {

        return k;
    }
}
