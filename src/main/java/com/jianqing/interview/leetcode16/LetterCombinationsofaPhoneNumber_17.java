package com.jianqing.interview.leetcode16;

import java.util.*;

/**
 * Created by jianqing_sun on 3/30/17.
 */
public class LetterCombinationsofaPhoneNumber_17 {

    public static void main(String[] args) {
        LetterCombinationsofaPhoneNumber_17 l = new LetterCombinationsofaPhoneNumber_17();
        l.letterCombinations("23");
    }

    public List<String> letterCombinations(String digits) {
        Map<Character, List<Character>> dict = new HashMap<>();

        dict.put('2', Arrays.asList('a', 'b', 'c'));
        dict.put('3', Arrays.asList('d', 'e', 'f'));
        dict.put('4', Arrays.asList('g', 'h', 'i'));
        dict.put('5', Arrays.asList('j', 'k', 'l'));
        dict.put('6', Arrays.asList('m', 'n', 'o'));
        dict.put('7', Arrays.asList('p', 'q', 'r', 's'));
        dict.put('8', Arrays.asList('t', 'u', 'v'));
        dict.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        StringBuffer sb = new StringBuffer();
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        helper(0, digits, dict, sb, res);

        return res;
    }

    public void helper(int index, String digits, Map<Character, List<Character>> dict, StringBuffer sb, List<String> res) {

        if (index == digits.length()) {
            res.add(new String(sb.toString()));
            return;
        }

        char c = digits.charAt(index);
        if (dict.containsKey(c)) {
            List<Character> clist = dict.get(c);
            for (int i = 0; i < clist.size(); i++) {
                sb.append(clist.get(i));
                helper(index + 1, digits, dict, sb, res);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        return;

    }
}
