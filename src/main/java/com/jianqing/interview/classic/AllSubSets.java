package com.jianqing.interview.classic;

import java.util.LinkedList;

/**
 * Created by jianqingsun on 2/16/17.
 */
public class AllSubSets {
    public static void main(String[] args) {
        AllSubSets allSubSets = new AllSubSets();
        char[] arrs = new char[]{'a','b','c'};
        allSubSets.allSubSets(arrs);
    }

    public void allSubSets(char[] arrs) {
        backtracking(0, new LinkedList<Character>(), arrs);
    }

    public void backtracking(int start, LinkedList<Character> currentList, char[] arrays) {

        print(currentList);

        if ( start > arrays.length)
            return;

        for (int i = start; i < arrays.length; i++) {
            currentList.add(arrays[i]);
            backtracking(i + 1, currentList, arrays);
            currentList.removeLast();
        }
    }

    public void print(LinkedList<Character> list) {
        for ( char c : list) {
            System.out.print(c + " ");
        }
        System.out.println("");
        return;
    }


}
