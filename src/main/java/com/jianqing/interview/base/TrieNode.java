package com.jianqing.interview.base;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jianqing_sun on 10/9/17.
 */
public class TrieNode {
    public Map<Character, String> children = new HashMap<>();
    Character c;
    public String word;

    public TrieNode(Character c) {
        this.c = c;
    }
}
