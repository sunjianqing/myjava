package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 3/19/18.
 */
public class FindSmallestLetterGreaterThanTarget_744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int i = 0;
        while( i < letters.length){
            if(letters[i] > target){
                return letters[i];
            }
            i++;
        }

        return letters[0];
    }
}
