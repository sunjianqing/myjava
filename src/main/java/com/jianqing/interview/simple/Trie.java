package com.jianqing.interview.simple;

import util.TrieNode;

/**
 * Created by jianqing_sun on 2/20/17.
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {

        if (search(word)) {
            return;
        }

        int i = 0;
        TrieNode curNode = root;
        while (i < word.length()) {

            char c = word.charAt(i);
            if (curNode.ndoeMap.containsKey(c)) {
                curNode = curNode.ndoeMap.get(c);
            } else {
                TrieNode newTrieNode = new TrieNode(c);
                if ( i == word.length() -1 )
                    newTrieNode.hasWord = true;
                curNode.ndoeMap.put(c, newTrieNode);
            }

            i++;
        }

    }

    public boolean search(String word) {
        return true;
    }

    public boolean startsWith(String prefix) {
        return true;
    }
}
