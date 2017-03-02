package util;

import java.util.HashMap;

/**
 * Created by jianqing_sun on 2/20/17.
 */
public class TrieNode {
    public char c;
    public HashMap<Character, TrieNode> ndoeMap = new HashMap<>();

    public boolean hasWord;

    public TrieNode(){
    }

    public TrieNode(char c){
        this.c = c;
    }
}
