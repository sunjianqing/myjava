package com.jianqing.interview.facebook.lc20;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Input: words = ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]]
 *
 */
public class LC_336_PalindromePairs {

    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> res = new ArrayList<>();
        Map<String, Integer> wm = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
           wm.put(words[i], i);
        }

        // case 1 整个reverse string， 如果存在， 可以组成Palindrome
        for (int i = 0; i < words.length; i++) {
            String reversedStr = new StringBuilder(words[i]).reverse().toString();
            if (wm.containsKey(reversedStr) && i != wm.get(reversedStr)) {
                res.add(Arrays.asList(i, wm.get(reversedStr)));
            }
        }

        // case 2，如果当前字符串尾部可以组成Palindrome， 去掉后， reverse string，还在map里，那也可以组成， 比如， race 跟 car
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            int len = w.length();
            for (int j = 0; j < len; j++) {
                String tail = w.substring(len - j - 1, len);
                if (isPalindrome(tail)) {
                    String leftReversed = new StringBuilder(w.substring(0, len - j - 1)).reverse().toString();
                    if (wm.containsKey(leftReversed)) {
                       res.add(Arrays.asList(i, wm.get(leftReversed)));
                    }
                }
            }
        }

        // case 3, 如果当前字符串头部可以组成Palindrome， 去掉后， reverse string，还在map里，那也可以组成， 比如， atac 跟 c, ata 自己是个palindrome， 剩下的c 在 map里
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            int len = w.length();
            for (int j = 0; j < len; j++) {
                String head = w.substring(0, j + 1);
                if (isPalindrome(head)) {
                    String leftReversed = new StringBuilder(w.substring(j+1, len)).reverse().toString();
                    if (wm.containsKey(leftReversed)) {
                        res.add(Arrays.asList(wm.get(leftReversed), i));
                    }
                }
            }
        }

        return res;
    }

    private boolean isPalindrome(String s) {
        if(s.isEmpty()) return true;

        int i = 0, j = s.length() - 1;

        while (i <= j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;


    }

}
