package com.jianqing.interview.leetcode16;

import com.jianqing.interview.base.TrieNode;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by jianqing_sun on 10/9/17.
 */
public class WordSearchII_212 {

    public List<String> solution(char[][] board, List<String> words) {
       List<String> res = new ArrayList<>();

        TrieNode trieNode = buildTrie(words);
        return res;
    }

    private TrieNode buildTrie(List<String> words) {
        TrieNode root = new TrieNode('#');

        for(String word : words) {
            char[] chars = word.toCharArray();
            TrieNode tmp;
//            for() {
//
//            }
//            tmp.word = word;

        }
        return root;
    }
}
