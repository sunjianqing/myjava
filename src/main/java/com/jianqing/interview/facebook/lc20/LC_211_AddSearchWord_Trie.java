package com.jianqing.interview.facebook.lc20;

/**
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/
 */
public class LC_211_AddSearchWord_Trie {

    private class TrieNode {
        TrieNode[] children;
        boolean isWord;
        // String word; // 如果是个单词， 可以用word存下来
        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public LC_211_AddSearchWord_Trie() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }

            cur = cur.children[index];
        }

        cur.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
       return find(word, root, 0);
    }

    public boolean find(String word, TrieNode node, int index) {
        if (index == word.length()) {
            return node.isWord;
        }

        char c = word.charAt(index);

        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null && find(word, node.children[i], index + 1)) {
                    return true;
                }
            }

            return false;
        }
        else {
            return node.children[c - 'a'] != null && find(word, node.children[c-'a'], index+1);
        }

    }


}
